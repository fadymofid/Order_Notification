package com.example.sw_pj_2.service;

import com.example.sw_pj_2.model.account;
import com.example.sw_pj_2.model.category;
import com.example.sw_pj_2.model.product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.sw_pj_2.SwPj2Application.*;

@Service
public class ProductService {

    public void addProduct(product p ){
        boolean x=false;
        for (int i =0;i<productList.size();i++){
            if(productList.get(i).serialnumber.equals(p.serialnumber)&& productList.get(i).category.equals(p.category)){
                productList.get(i).Productcount++;
                productList.get(i).tempcount++;
                x=true;
                break;
            }
        }

            if(!x) {
            productList.add(p);
        }
            boolean cond =false;
        for (int i=0;i< cat.size();i++){

            if(cat.get(i).type.equals(p.category)){
                cat.get(i).products.add(p);
                cond=true;
            }
        }
            if (!cond){
                category c=new category(p);
                cat.add(c);
            }


    }
    public void removeProduct(product p){
        for (int i =0;i<productList.size();i++){
            if(productList.get(i).serialnumber.equals(p.serialnumber)&& productList.get(i).category.equals(p.category)){
                productList.get(i).Productcount--;
                productList.get(i).tempcount--;
                break;
            }
            else {
                productList.remove(p);
            }
        }
        for (int i=0;i< cat.size();i++){
            if(cat.get(i).type.equals(p.category)){
                cat.get(i).products.remove(p);
            }
        }

    }
    public List<product> getAllProducts() {
        return productList;
    }
    public product findProduct(String name) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).name.equals(name)) {
                return productList.get(i);
            }
        }
        return null;
    }

}
