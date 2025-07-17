package com.codegym.module4lesson3_baitap.service;

import com.codegym.module4lesson3_baitap.model.Product;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    private static List<Product> products = new ArrayList<>();
    private static int nextId = 1;

    static {
        products.add(new Product(nextId++, "iPhone", 999, "Apple smartphone", "Apple"));
        products.add(new Product(nextId++, "Galaxy", 899, "Samsung smartphone", "Samsung"));
    }

    public List<Product> findAll() { return products; }
    public Product findById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
    public void save(Product product) {
        product.setId(nextId++);
        products.add(product);
    }
    public void update(int id, Product product) {
        Product existing = findById(id);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            existing.setDescription(product.getDescription());
        }
    }
    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);
    }
    public List<Product> searchByName(String name) {
        return products.stream()
            .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
            .collect(Collectors.toList());
    }
}
