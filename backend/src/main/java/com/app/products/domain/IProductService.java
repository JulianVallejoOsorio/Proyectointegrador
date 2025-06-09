package com.app.products.domain;

import java.util.List;

public interface IProductService {

    List<Product> findAll();

    Product findById(Integer id);

    Product save(Product product);

    Product update(Product product, Integer id);

    void deleteById(Integer id);
}
