
package com.codegym.module4lesson3_baitap.service;

import com.codegym.module4lesson3_baitap.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<Integer, Product>();
        products.put(1, new Product(1, "Iphone 11", 12000000, "sale mạnh", "apple"));
        products.put(2, new Product(2, "Samsung s23", 25000000, "giá ưu đãi", "samsung"));
        products.put(3, new Product(3, "Iphone 15", 22000000, "sang trọng", "apple"));
        products.put(4, new Product(4, "Oppo x8 Pro", 15000000, "đẹp", "oppo"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(product);
            }
        }
        return result;
    }
}
