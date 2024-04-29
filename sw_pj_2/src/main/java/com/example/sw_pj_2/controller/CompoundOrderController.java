package com.example.sw_pj_2.controller;

import com.example.sw_pj_2.model.account;
import com.example.sw_pj_2.model.notification_temp;
import com.example.sw_pj_2.model.order;
import com.example.sw_pj_2.service.compound_order;
import com.example.sw_pj_2.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.sw_pj_2.SwPj2Application.notification_tem;
import static com.example.sw_pj_2.SwPj2Application.notification_ship;

@RestController
@RequestMapping("/compoundOrder")
public class CompoundOrderController {

    @Autowired
    private final compound_order compound_order;

    @Autowired
    public CompoundOrderController(compound_order orderService) {
        this.compound_order = orderService;
    }

    @PostMapping("/place-order")
    public List<notification_temp> placeOrder(@RequestParam String username, @RequestBody List<account> accounts) {
         compound_order.placeOrder(username, accounts);
        return notification_tem;

    }
    @GetMapping("/get-ship")
    public List<notification_temp> shipOrder(@RequestParam String username, @RequestBody List<account> accounts) {

        return notification_ship;

    }
    @PostMapping("/cancel")

    public List<account> cancel(@RequestParam String username, @RequestBody List<account> a) {
        return compound_order.cancel(username,a);
    }


    }