package com.example.sw_pj_2.model;

import com.example.sw_pj_2.service.OrderService;
//import com.example.sw_pj_2.service.compound_order;
import com.example.sw_pj_2.service.simple_order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public  class order {

    public List<product> orderedProducts=new ArrayList<>();
    public int orderid;

    public static Queue<notification_temp> notifications;
    public order(){
    }
    public int shipping=50;
    public List<product> tempproduct=new ArrayList<>();


    public float tempfees=0;





}
