package com.example.sw_pj_2;

import com.example.sw_pj_2.model.*;
import com.example.sw_pj_2.service.AccountProductService;
import com.example.sw_pj_2.service.AccountService;
import com.example.sw_pj_2.service.OrderService;
import com.example.sw_pj_2.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@SpringBootApplication
public class SwPj2Application {
	public static List<account> accountList=new ArrayList<>();
	public static List<product> productList=new ArrayList<>();
	public static List<order> orders = new ArrayList<>();
	public static List<category> cat = new ArrayList<>();
	public static ProductService productService=new ProductService();
	public static AccountService accountService=new AccountService();
	public static AccountProductService accpro=new AccountProductService (accountService,productService);
	public static List<notification_temp> notification_tem= new ArrayList<>();
	public static List<notification_temp> notification_ship= new ArrayList<>();
	public static String setTime() {
		LocalDateTime currentTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String time = currentTime.format(formatter);
		return time;
	}







	public static void main(String[] args) {

		account acc=new account("2", "2", "2", 200, "2", "2");
		accountList.add(acc);
		accountList.add(new account("user1", "e", "a", 100, "1", "a"));
		accountList.add(new account("3", "3", "3", 300, "3", "3"));
		accountList.add(new account("1", "2", "2", 200, "2", "2"));
		accountList.add(new account("4", "2", "2", 400, "2", "2"));
		product x =new product("1", "phone", "a", 100,"elec");
		product p =new product("2", "phone", "a", 100,"elec");
		product ca =new product("3", "Bannana", "a", 100,"food");
		product d =new product("4", "adel", "a", 100,"baba");
		product da =new product("5", "awad", "a", 100,"baba");

		product f =new product("6", "5aled", "a", 100,"baba");
		category ma=new	 category(x);
		cat.add(ma);
		productList.add(x);
		productService.addProduct(p);
		productService.addProduct(ca);
		productService.addProduct(d);
		productService.addProduct(f);
		productService.addProduct(da);
		accpro.addtocart("3","Bannana");
		accpro.addtocart("1","phone");
		accpro.addtocart("4","adel");
		accpro.addtocart("2","awad");


		SpringApplication.run(SwPj2Application.class, args);
	}

}
