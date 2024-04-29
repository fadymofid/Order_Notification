package com.example.sw_pj_2.service;

import com.example.sw_pj_2.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import static com.example.sw_pj_2.SwPj2Application.accountList;
import static com.example.sw_pj_2.SwPj2Application.orders;

@Service
public class simple_order extends  OrderService {
    public simple_order(List<product> ordered) {
        super(ordered);
    }

    public simple_order() {
    }


    public static int k = 0;

    public order placeOrder(String username, List<account> a) {

        order ord = new order();

        int y;
        simple_order simpleOrr = null;
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).username.equals(username)) {
                if (a.isEmpty()) {

                    accountList.get(i).balance -= ord.shipping;
                } else {
                    y = ord.shipping / a.size();
                    accountList.get(i).balance -= y;
                }
                simpleOrr = new simple_order(accountList.get(i).shoppingcart);
                float shippingFees = calculateShippingFees(accountList.get(i));
                accountList.get(i).balance -= shippingFees;
                ord.tempfees += shippingFees;
                ord.tempproduct.addAll(accountList.get(i).shoppingcart);
                ord.orderedProducts.addAll(accountList.get(i).shoppingcart);
                add(ord);
                ord.orderid = orders.get(0).orderid;
                accountList.get(i).tempcart .addAll( accountList.get(i).shoppingcart);
                accountList.get(i).shoppingcart.clear();
                order_noti x = new order_noti();
                ship_notify z = new ship_notify();
                x.placeordernoti(ord, accountList.get(i));
                z.placeshipmentnoti(ord, accountList.get(i));
                break;
            }
        }
        notifynoti();

        return ord;


    }
    public account cancel(String username,List<account> a){
        account acc=null;
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).username.equals(username)) {
           float x=recalculatefees(accountList.get(i));
           System.out.println(x);
           accountList.get(i).balance+=x;
            return accountList.get(i);
            }
    }
        return acc;

}
}


