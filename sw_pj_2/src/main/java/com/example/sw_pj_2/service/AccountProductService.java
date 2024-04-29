package com.example.sw_pj_2.service;

import com.example.sw_pj_2.model.account;
import com.example.sw_pj_2.service.AccountService;
import com.example.sw_pj_2.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import static com.example.sw_pj_2.SwPj2Application.accountList;


@Service
public class AccountProductService  {

    private final AccountService serv;
    private final ProductService Prsev;

    @Autowired
    public AccountProductService(AccountService serv, ProductService Prsev) {
        this.serv = serv;
        this.Prsev = Prsev;
    }
    public List<product> viewShoppingcart(String username) {
        account acc=serv.findAccountByUsername(username);
        return acc.shoppingcart;
    }

    public ResponseEntity<String> addtocart(String username, String name) {
        account acc=serv.findAccountByUsername(username);
        product pr=Prsev.findProduct(name);
        acc.shoppingcart.add(pr);
        pr.tempcount--;
        String Message = "Product added to cart successfully";
        System.out.println(Message);
        return  ResponseEntity.status(HttpStatus.ACCEPTED).body(Message);


    }

    public void removefromcart( String username, String name) {
        account acc =serv.findAccountByUsername(username);
        product pr=Prsev.findProduct(name);

        acc.shoppingcart.remove(pr);
        pr.tempcount++;
    }
}
