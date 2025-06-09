package com.app.products.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.products.domain.IProductRepository;
import com.app.products.domain.Product;

@Component
public class ProductDatasource {

    private final IProductRepository productRepository;

    public ProductDatasource(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> update(Product product, Integer id) {
        return productRepository.findById(id).map(existingProduct -> {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStock(product.getStock());
            existingProduct.setImage(product.getImage());
            existingProduct.setCategoryId(product.getCategoryId());
            return productRepository.save(existingProduct);
        });
    }

    public boolean deleteById(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
