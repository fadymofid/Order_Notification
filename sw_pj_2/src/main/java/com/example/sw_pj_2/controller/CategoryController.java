package com.example.sw_pj_2.controller;

import com.example.sw_pj_2.model.category;
import com.example.sw_pj_2.model.product;
import com.example.sw_pj_2.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class    CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/getProducts")
    public List<product> getAllCategoryProducts(@RequestParam String name) {
        return categoryService.getAllCatProducts(name);
    }
    @GetMapping("/getCategory")
    public List<category> getAllCategoryProducts() {
        return categoryService.getAllCat();
    }
}
