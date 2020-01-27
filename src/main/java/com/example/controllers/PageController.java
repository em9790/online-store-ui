package com.example.controllers;

import com.example.onlinestoreservice.dao.ICategoryDAO;
import com.example.onlinestoreservice.dto.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.swing.text.html.Option;
import java.util.List;

@Controller
public class PageController {

    @Autowired
    private ICategoryDAO categoryDAO ;

    @RequestMapping(value = {"/" , "/home", "/page"})
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Home");
        mv.addObject("userClickHome", true);
        List<Category> list = categoryDAO.list();
        mv.addObject("categories", list);
        return mv;
    }

    @RequestMapping(value = "/about")
    public ModelAndView about(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "About Us");
        mv.addObject("userClickAbout", true);
        return mv;
    }

    @RequestMapping(value = "/contact")
    public ModelAndView contact(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "Contact Us");
        mv.addObject("userClickContact", true);
        return mv;
    }

    /*Methods to load all the products and based on category*/
    @RequestMapping(value = "/show/all/products")
    public ModelAndView showAllProducts(){
        ModelAndView mv = new ModelAndView("page");
        mv.addObject("title", "home");
        mv.addObject("userClickAllProducts", true);
        mv.addObject("categories", categoryDAO.list());
        return mv;
    }

    @RequestMapping(value = "/show/category/{id}/products")
    public ModelAndView showProduct(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("page");
        Category category = categoryDAO.get( id);

        mv.addObject("title", category.getName());
        mv.addObject("userClickCategoryProducts", true);
        mv.addObject("categories", categoryDAO.list());
        mv.addObject("category", category);
        return mv;
    }
}
