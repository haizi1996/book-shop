package com.book.controller;

import com.book.dto.AbstractResult;
import com.book.dto.BaseResult;
import com.book.model.Book;
import com.book.model.Category;
import com.book.service.AdminService;
import com.book.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class AdminController {

    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;


    public static final Integer PAGE_SIZE = 10;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String home() {
        List<Book> books = adminService.getAllBook(1, PAGE_SIZE);
        return "admin/index";
    }

    @RequestMapping(value = "/admin/addBook", method = RequestMethod.GET)
    public String addBook(Model model) {
        List<Category> categories = adminService.getAllCategories();
        AbstractResult baseResult = categories == null ? BaseResult.error("") : BaseResult.success(categories);
        model.addAttribute("baseResult", baseResult);
        return "admin/add_books";
    }


    @RequestMapping(value = "/admin/doAddBook", method = RequestMethod.POST)
    @ResponseBody
    public String doAddBook(MultipartFile image, Book book , HttpServletRequest request ) {
        if (image != null) {
            String fileName = image.getOriginalFilename();
            fileName = UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("\\") + 1);
            String type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null&&("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase()))) {
                String realPath=request.getSession().getServletContext().getRealPath("/")+"img/";
                try {
                    image.transferTo(new File(realPath+fileName));
                    book.setImageUrl(File.separator+"img" + File.separator + fileName );
                    Integer row  = adminService.addBook(book);
                    if(row > 0){
                        return JsonUtil.objectToJson(BaseResult.error("添加书籍成功!!"));
                    }
                    return JsonUtil.objectToJson(BaseResult.error("添加书籍失败!!"));
                }catch (IOException e){
                    logger.error(e.getMessage());
                    return JsonUtil.objectToJson(BaseResult.error("添加书籍失败!!"));
                }
            }else{
                return JsonUtil.objectToJson(BaseResult.error("图片类型不一致!!"));
            }
        } else {
            return JsonUtil.objectToJson(BaseResult.error("没有找到对应的文件！！"));
        }
    }


    @RequestMapping(value="/admin/showAllCategoies",method = RequestMethod.GET)
    public String showAllCategories(Model model){
        List<Category> categories = adminService.getAllCategories();
        AbstractResult baseResult = categories == null ? BaseResult.error("") : BaseResult.success(categories);
        model.addAttribute("baseResult", baseResult);
        return "admin/listCategory";
    }

}
