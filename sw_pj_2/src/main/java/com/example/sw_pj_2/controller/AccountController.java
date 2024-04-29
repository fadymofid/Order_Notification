package com.example.sw_pj_2.controller;
import com.example.sw_pj_2.model.account;
import com.example.sw_pj_2.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public ResponseEntity<String> registerAccount(@RequestBody account newAccount) {

        return accountService.register(newAccount);
    }


    @GetMapping("/login")
    public account loginAccount(@RequestParam String username, @RequestParam String password) {

        return accountService.login(username, password);
    }
    @GetMapping("/getUser")
    public ResponseEntity<String> FindUser(@RequestParam String username) {


        return accountService.getByUserAndPass(username);
    }
//    @GetMapping("/login")


    @GetMapping("/list")
    public List<account> getAllAccounts() {
        return accountService.getAllAccounts();
    }


}




