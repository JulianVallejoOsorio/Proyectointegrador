package com.app.categories.domain;

import java.util.List;

public interface ICategoryService {
    
    List<Category> findAll();

    Category findById(Integer id);

    Category save(Category category);

    Category update(Category category, Integer id);

    void deleteById(Integer id);
}
