package com.example.sw_pj_2.model;


import java.util.ArrayList;
import java.util.List;

public class account {
    public account() {
    }
    public String email;

    public String password;

    public float balance;

    public String phonenumber;


    public String username;

   public List<product> shoppingcart=new ArrayList<>();
    public List<product> tempcart=new ArrayList<>();

    public String address;
     public Role role=Role.customer;


    public account (String username,String email,String password,float balance,String phonenumber,String address){
        this.username=username;
        this.password=password;
        this.balance=balance;
        this.phonenumber=phonenumber;
        this.email=email;
        this.address=address;
    }
    public account(String username, String password){
        this.username=username;
        this.password=password;
    }
}