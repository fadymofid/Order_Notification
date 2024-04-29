package com.example.sw_pj_2.model;

import java.util.ArrayList;
import java.util.List;

public class category {
    public String type;

    public List<product> products=new ArrayList<>();


    public int count=0;

    public category () {
    }
    public category (product p) {
        this.type=p.category;
        products.add(p);
        count = products.size();
    }

    public int getcont(){
        return count;
    }
}
