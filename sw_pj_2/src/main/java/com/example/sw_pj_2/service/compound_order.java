package com.example.sw_pj_2.service;

import com.example.sw_pj_2.model.account;
import com.example.sw_pj_2.model.order;
import com.example.sw_pj_2.model.product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.sw_pj_2.SwPj2Application.accountList;

@Service
public class compound_order extends OrderService {

    public List<order> orders;

    public compound_order() {
        super(new ArrayList<>());
        this.orders = new ArrayList<>();
    }

    public void addOrder(order order) {
        orders.add(order);
    }

    public void removeOrder(order order) {
        orders.remove(order);
    }



    public List<order>  placeOrder(String username, List<account> friends) {
        orders.clear();



        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).username.equals(username)) {
                friends.add(accountList.get(i));


            }
        }


        for(int i=0;i< friends.size();i++){

            simple_order s=new simple_order(friends.get(i).shoppingcart);
            orders.add(s.placeOrder(friends.get(i).username,friends));
        }

        return orders;
    }
    public List<account>  cancel(String username, List<account> friends) {
orders.clear();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).username.equals(username)) {
                friends.add(accountList.get(i));


            }
        }
        for(int i=0;i< friends.size();i++){

            simple_order s=new simple_order(friends.get(i).shoppingcart);
        }
        return friends;
    }

}

