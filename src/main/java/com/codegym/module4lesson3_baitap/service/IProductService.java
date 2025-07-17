package com.codegym.module4lesson3_baitap.service;

import com.codegym.module4lesson3_baitap.model.Product;
import java.util.List;


public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void save(Product product);
    void update(int id, Product product);
    void delete(int id);
    List<Product> searchByName(String name);
}
