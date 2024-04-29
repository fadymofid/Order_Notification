package com.example.sw_pj_2.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static com.example.sw_pj_2.SwPj2Application.notification_ship;

public class ship_notify extends notification_temp {
    public ship_notify() {
        type = "shipment";
        subject = "Order Shipment";
        languages = "english";
        channel="email";
        setTime();
    }

    private void setTime() {
        LocalDateTime currentTime = LocalDateTime.now().plusMinutes(1); // Set time after 1 minute
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        time = currentTime.format(formatter);
    }

    public void placeshipmentnoti(order or, account acc) {
        placeholders.add(acc.username);
        ship_notify sn = new ship_notify();
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("Dear ").append(acc.username);
        messageBuilder.append(" Your order id ").append(or.orderid);
        messageBuilder.append(" has been shipped");
        messageBuilder.append(" at time ").append(time);
        messageBuilder.append(" a message is sent to ").append(channel);
        String message = messageBuilder.toString();
        sn.content = message;
        notification_ship.add(sn);
    }
}
