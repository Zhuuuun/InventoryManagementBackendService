package com.zhunismp.project1.services;

import com.zhunismp.project1.dao.ProductDAO;
import com.zhunismp.project1.entity.Product;
import com.zhunismp.project1.exception.OrderNotFoundException;
import com.zhunismp.project1.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    @Transactional
    public void saveProduct(Product product) {
        productDAO.save(product);
    }

    @Override
    @Transactional
    public void deleteProductById(int id) {
        if(productDAO.findProductById(id) == null) throw new ProductNotFoundException("Product doesn't exist for product id : " + id);
        productDAO.deleteProductById(id);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    @Override
    public Product findProductById(int id) {
        if(productDAO.findProductById(id) == null) throw new ProductNotFoundException("Product doesn't exist for product id : " + id);
        return productDAO.findProductById(id);
    }

    @Override
    public List<Product> findAllProduct() {
        return productDAO.findAllProduct();
    }
}
