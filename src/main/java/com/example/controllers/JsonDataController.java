package com.example.controllers;

import com.example.onlinestoreservice.dao.IProductDAO;
import com.example.onlinestoreservice.daoimpl.ProductDAO;
import com.example.onlinestoreservice.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {

    @Autowired
    private IProductDAO productDAO;

    @RequestMapping("/all/products")
    @ResponseBody
    public List<Product> getAllProducts(){
        return productDAO.listActive();
    }

    @RequestMapping("/category/{id}/products")
    @ResponseBody
    public List<Product> getAllProductsByCategory(@PathVariable int id){
        return productDAO.listActiveProductsByCategory(id);
    }
}
