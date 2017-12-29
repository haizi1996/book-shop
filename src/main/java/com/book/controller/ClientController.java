package com.book.controller;

import com.book.dto.Page;
import com.book.model.BookDetail;
import com.book.model.User;
import com.book.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ClientController {
    public static final Integer PAGE_SIZE = 10;
    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "/" , method = RequestMethod.GET)
    public String welcome(@RequestParam(defaultValue = "1") Integer pageNum , Model model){
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
}
