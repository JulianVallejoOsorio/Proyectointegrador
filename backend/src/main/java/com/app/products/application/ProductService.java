package com.app.products.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.products.domain.IProductRepository;
import com.app.products.domain.IProductService;
import com.app.products.domain.Product;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("product not found with ID: " + id));
    }

    @Override
    @Transactional
    public Product save(Product product) {
        // Puedes agregar validaciones aquí si es necesario, por ejemplo:
        if (product.getPrice() < 0) {
            throw new IllegalArgumentException("price cannot be negative");
        }
        if (product.getStock() < 0) {
            throw new IllegalArgumentException("stock cannot be negative");
        }
        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product update(Product product, Integer id) {
        Product existingProduct = findById(id);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setStock(product.getStock());
        existingProduct.setImage(product.getImage());
        existingProduct.setCategoryId(product.getCategoryId());
        return productRepository.save(existingProduct);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Product product = findById(id);
        productRepository.delete(product);
    }
}
