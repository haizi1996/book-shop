package com.book.controller;

import com.book.dto.BaseResult;
import com.book.dto.Page;
import com.book.model.*;
import com.book.service.ClientService;
import com.book.util.JsonUtil;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.lang.model.type.IntersectionType;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ClientController {
    public static final Integer PAGE_SIZE = 10;
    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String welcome(@RequestParam(defaultValue = "1") Integer pageNum , Model model , HttpServletRequest request){
        List<Category> categories = clientService.findAllCategory();
        request.getSession().setAttribute("cs" , categories);
        List<BookDetail> bookDetails = clientService.getPageNumBook(pageNum , PAGE_SIZE);
        Integer totalRecords = clientService.getTotalRecords();
        Page page = new Page(pageNum , totalRecords , PAGE_SIZE).setRecords(bookDetails);
        model.addAttribute("page" , page);
        return "/client/welcome";
    }


    @RequestMapping(value = "/loginUI" , method = RequestMethod.GET)
    public String loginUI(){
        return "/client/login";
    }

    @RequestMapping(value = "/login" , method = RequestMethod.POST)
    @ResponseBody
    public String login(User user){
        User mod = clientService.login(user);
        if(mod != null){

        }
        return "/client/login";
    }


    @RequestMapping(value = "/regist/add")
    @ResponseBody
    public String regist(User user , HttpServletRequest request){
        Integer row = clientService.regist(user);
        if(row > 0){
            request.getSession().setAttribute("user" , user);
        }
        return "diriect:/";
    }

    @RequestMapping(value = "/client/book/{id}/detail" , method = RequestMethod.GET)
    public String getBookDetail(@PathVariable Integer id , Model model , HttpServletRequest request){
        List<Category> categories = clientService.findAllCategory();
        request.getSession().setAttribute("cs" , categories);
        BookDetail bookDetail = clientService.getBookDetailById(id);
        model.addAttribute("book" , bookDetail);
        return "client/detail";
    }


    @RequestMapping(value = "/client/addCart/{id}" , method = RequestMethod.GET , produces = "application/json;charset=utf-8")
    @ResponseBody
    public String addCart(@PathVariable Integer id , HttpServletRequest request){
        Book book = clientService.getBookDetailById(id);
        Cart cart = (Cart)request.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
        }
        cart.addBook(book);
        request.getSession().setAttribute("cart" , cart);
        return JsonUtil.objectToJson(BaseResult.success("加入购物车成功！！"));
    }

    @RequestMapping(value = "/client/showCart" , method = RequestMethod.GET)
    public String showCart(){
        return "client/showCart";
    }
}
