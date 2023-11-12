package com.zhunismp.project1.services;

import com.zhunismp.project1.entity.Product;

import java.util.List;

public interface ProductService {
    void saveProduct(Product product);
    void deleteProductById(int id);
    void updateProduct(Product product);
    Product findProductById(int id);
    List<Product> findAllProduct();
}
