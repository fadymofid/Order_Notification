    package com.example.sw_pj_2.service;

    import com.example.sw_pj_2.model.notification_temp;
    import com.example.sw_pj_2.model.order;

    public interface notification_service {
        public abstract void update(order or);
        public abstract void applyTemp(notification_temp nt);
    }
