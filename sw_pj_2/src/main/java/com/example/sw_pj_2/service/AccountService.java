package com.example.sw_pj_2.service;
import com.example.sw_pj_2.SwPj2Application;
import com.example.sw_pj_2.model.account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import static com.example.sw_pj_2.SwPj2Application.accountList;

@Service
public class AccountService {


    public AccountService(){
        account acc=new account("3", "2", "2", 200, "2", "2");
        accountList.add(acc);
    }
        public account login(String username, String password) {
            for (int i=0;i<accountList.size();i++) {
                if(accountList.get(i).username.equals(username)&& accountList.get(i).password.equals(password)){
                    return accountList.get(i);
                }
            }
            return  null;
        }
        public ResponseEntity<String> getByUserAndPass(String username){
            for (int i=0;i<accountList.size();i++) {
                if(accountList.get(i).username.equals(username)){
                    String Message = "Account found";
                    System.out.println(Message);
                    return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message);
                }
            }
            String Message = "Account is not found";
            System.out.println(Message);
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Message);
        }

    public ResponseEntity<String> register(account account) {

        for (int i=0;i<accountList.size();i++) {
           if(accountList.get(i).email.equals(account.email)){
               String errorMessage = "Email already taken. Please enter another email.";
               System.out.println(errorMessage);
               return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);

           }
        }
        accountList.add(account);
        return ResponseEntity.status(HttpStatus.CREATED).body("Registration successful!");
        }


    public account findAccountByUsername(String username) {
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).username.equals(username)) {
                return accountList.get(i);
            }
        }
        return null;
    }
    public List<account> getAllAccounts() {
        return accountList;
    }



}