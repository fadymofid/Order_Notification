package com.example.sw_pj_2.service;

import com.example.sw_pj_2.model.account;
import com.example.sw_pj_2.model.category;
import com.example.sw_pj_2.model.product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.sw_pj_2.SwPj2Application.accountList;
import static com.example.sw_pj_2.SwPj2Application.productList;
import static com.example.sw_pj_2.SwPj2Application.cat;

@Service
public class CategoryService {
    private final ProductService Prsev;

    @Autowired
    public CategoryService(ProductService prsev) {
        this.Prsev = prsev;
    }



    public category findCat(String name) {
        for (int i = 0; i < cat.size(); i++) {
            if (cat.get(i).type.equals(name)) {
                return cat.get(i);
            }
        }
        return null;
    }
    public int getcount(String name){
        for (int i = 0; i < cat.size(); i++) {
            if (cat.get(i).type.equals(name)) {
                return cat.get(i).count;
            }
        }
        return 0;
    }


    public List<product> getAllCatProducts(String name) {
        for(int i=0;i<cat.size();i++) {
         if(cat.get(i).type.equals(name))
            return cat.get(i).products;
        }
        return null;
    }
    public List<category> getAllCat() {
        return cat;
    }
}
