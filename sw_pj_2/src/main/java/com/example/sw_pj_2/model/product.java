package com.example.sw_pj_2.model;
public class product {
    public product (String serialnumber,String name,String vendor,float price,String category){
        this.serialnumber=serialnumber;
        this.name=name;
        this.vendor=vendor;
        this.price=price;
        this.category=category;
    }
    public product() {
    }
    public String serialnumber;

    public String name;

    public String vendor;

    public float price;

    public String category;

    public int Productcount=1;

    public int tempcount=Productcount;


}