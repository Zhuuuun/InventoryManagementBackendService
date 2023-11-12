package com.zhunismp.project1.dao;

import com.zhunismp.project1.entity.Product;

import java.util.List;

public interface ProductDAO {
    void save(Product product);
    void deleteProductById(int id);
    void update(Product product);
    Product findProductById(int id);
    List<Product> findAllProduct();
}
