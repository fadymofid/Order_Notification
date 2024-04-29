package com.example.sw_pj_2.controller;
import com.example.sw_pj_2.model.account;
import com.example.sw_pj_2.model.notification_temp;
import com.example.sw_pj_2.model.order;
import com.example.sw_pj_2.service.AccountService;
import com.example.sw_pj_2.service.simple_order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.example.sw_pj_2.SwPj2Application.notification_tem;
import static com.example.sw_pj_2.SwPj2Application.notification_ship;

import java.util.List;

@RestController
@RequestMapping("/order")
public class simple_order_controller {
    @Autowired
    private simple_order simpleOrder;
    @PostMapping("/placeSimpleOrder")
    public notification_temp placeSimpleOrder(@RequestParam String username, @RequestBody List<account> a) {

         simpleOrder.placeOrder(username, a);
         return notification_tem.get(notification_tem.size()-1);

    }
    @GetMapping("/ship")
    public  notification_temp  getShip(@RequestParam String username, @RequestBody List<account> a) {
        return notification_ship.get(notification_ship.size()-1);
    }
    @PostMapping("/cancelorder")
    public account cancel(@RequestParam String username ,@RequestBody List<account> a) {
        return simpleOrder.cancel(username,a);

    }
//    @GetMapping("/getDetails")
//    public order DisplayOrder(@RequestParam String orderid){
//        return simpleOrder.orderdetails(orderid);


}