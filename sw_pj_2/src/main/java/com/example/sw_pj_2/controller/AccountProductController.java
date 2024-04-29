package com.example.sw_pj_2.controller;

import com.example.sw_pj_2.model.account;
import com.example.sw_pj_2.model.product;
import com.example.sw_pj_2.service.AccountProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account/product")
public class AccountProductController  {

    @Autowired
    private AccountProductService accountProductService;

    @GetMapping("/view")
    public List<product> viewShoppingCart(@RequestParam String username) {
        return accountProductService.viewShoppingcart(username);
    }

    @PostMapping  ("/add")
    public ResponseEntity<String> addToCart(@RequestParam String username, @RequestParam String name) {
        return accountProductService.addtocart(username, name);
    }

    @PostMapping("/remove")
    public void removeFromCart(@RequestParam String username, @RequestParam String name) {
        accountProductService.removefromcart(username, name);
    }

}
