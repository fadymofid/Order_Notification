package com.example.sw_pj_2.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.example.sw_pj_2.SwPj2Application.notification_tem;
import static com.example.sw_pj_2.SwPj2Application.setTime;

public class order_noti extends notification_temp {
    public order_noti() {
        type = "order";
        subject="Your order";
        languages="english";
        time=setTime();
    }



    public void placeordernoti(order or, account acc) {
        placeholders.add(acc.username);
        order_noti on=new order_noti();
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("Dear ").append(acc.username);
        messageBuilder.append(" Your order id is ").append(or.orderid);
        messageBuilder.append(" and the Fees are ").append(or.tempfees);
        messageBuilder.append(" and the ordered products are ");

        for (int i = 0; i < or.tempproduct.size(); i++) {
            messageBuilder.append(or.tempproduct.get(i).name);
            if (i < or.tempproduct.size() - 1) {
                messageBuilder.append(", ");
            }
        }

        messageBuilder.append(" Thank you for ordering");
        messageBuilder.append(" at time").append(time);

        String message = messageBuilder.toString();
        on.content=messageBuilder.toString();
        notification_tem.add(on);
    }
}
