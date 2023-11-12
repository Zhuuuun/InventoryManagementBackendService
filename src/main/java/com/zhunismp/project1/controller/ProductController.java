package com.zhunismp.project1.controller;

import com.zhunismp.project1.entity.Product;
import com.zhunismp.project1.response.ResponseHandler;
import com.zhunismp.project1.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<Object> getAllProducts() {
        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                productService.findAllProduct()
        );
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Object> getProductById(@PathVariable int productId) {
        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                productService.findProductById(productId)
        );
    }

    @PostMapping("/product/add")
    public ResponseEntity<Object> addProduct(@RequestBody Product product) {
        productService.saveProduct(product);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                null
        );
    }

    @DeleteMapping("/product/delete/{productId}")
    public ResponseEntity<Object> deleteProductById(@PathVariable int productId) {
        productService.deleteProductById(productId);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                null
        );
    }

    @PutMapping("/product/update")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);

        return ResponseHandler.responseBuilder(
                "Request successfully : from " + new Object(){}.getClass().getEnclosingMethod().getName() + "()",
                HttpStatus.OK,
                null
        );
    }

}
