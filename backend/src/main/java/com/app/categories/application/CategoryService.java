package com.app.categories.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.categories.domain.ICategoryRepository;
import com.app.categories.domain.ICategoryService;
import com.app.categories.domain.Category;

@Service
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("category not found with ID: " + id));
    }

    @Override
    @Transactional
    public Category save(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new IllegalArgumentException("category name already exists: " + category.getName());
        }
        return categoryRepository.save(category);
    }

    @Override
    @Transactional
    public Category update(Category category, Integer id) {
        Category existingCategory = findById(id);
        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Category category = findById(id);
        categoryRepository.delete(category);
    }
}
