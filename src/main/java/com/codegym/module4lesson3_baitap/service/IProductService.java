
package com.codegym.module4lesson3_baitap.service;

import com.codegym.module4lesson3_baitap.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(int id,Product product);

    void remove(int id);

    List<Product> searchByName(String name);
}
