package com.example.sw_pj_2.service;

import com.example.sw_pj_2.model.account;
import com.example.sw_pj_2.model.order;
import com.example.sw_pj_2.model.product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.example.sw_pj_2.SwPj2Application.accountList;

import java.util.List;
import static com.example.sw_pj_2.SwPj2Application.orders;

public abstract class OrderService {
    public order order=new order();
    public static int orderid=0;
    public OrderService(List<product> products){
        order.orderedProducts=products;
    }

    public OrderService(){}

    public float calculateShippingFees(account acc){
        float all=0;
        for(int i=0;i<acc.shoppingcart.size();i++){

            all += acc.shoppingcart.get(i).price;
            acc.shoppingcart.get(i).Productcount--;

        }
        return all;
    }
    public float recalculatefees(account acc){
        float all=0;
        for(int i=0;i<acc.tempcart.size();i++){

            all += acc.tempcart.get(i).price;
            acc.tempcart.get(i).Productcount++;

        }
        return all;
    }
    public void add(order ord) {
        orderid++;
        order.tempfees=ord.tempfees;
        order.orderid=orderid;
        order.orderedProducts=ord.orderedProducts;
        order.tempproduct=ord.tempproduct;
        orders.add(order);
    }




    public void removeorder(account acc) {
        for (product prod : order.orderedProducts) {
            prod.Productcount++;
        }


    }

    public order getorder() {
        return order;
    }

    public void addnotification() {

    }

    public void removenotification() {
    }
public int getshipping  (){
        return  order.shipping;
}

    public void notifynoti() {
    }

}
