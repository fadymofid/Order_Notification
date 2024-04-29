    package com.example.sw_pj_2.controller;
    import com.example.sw_pj_2.model.account;
    import com.example.sw_pj_2.model.product;
    import com.example.sw_pj_2.service.ProductService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
        @RequestMapping("/products")
    public class ProductCotroller {

        @Autowired
        private ProductService productService;

        @PostMapping("/add")
        public void addProduct(@RequestBody product product) {
            productService.addProduct(product);
        }

        @PostMapping("/remove")
        public void removeProduct(@RequestBody product product) {
            productService.removeProduct(product);
        }
        @GetMapping("/list")
        public List<product> getAllProducts() {
            return productService.getAllProducts();
        }


    }
