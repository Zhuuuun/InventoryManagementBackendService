package com.zhunismp.project1.dao;

import com.zhunismp.project1.entity.Product;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private final EntityManager entityManager;

    @Autowired
    public ProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }


    @Override
    public void deleteProductById(int id) {
        entityManager.remove(entityManager.find(Product.class,id));
    }


    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public Product findProductById(int id) {
        return entityManager.find(Product.class,id);
    }

    @Override
    public List<Product> findAllProduct() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

}
