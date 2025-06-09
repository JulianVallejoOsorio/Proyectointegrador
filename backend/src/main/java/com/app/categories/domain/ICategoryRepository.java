package com.app.categories.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Override
    @NonNull
    List<Category> findAll();

    @Override
    @NonNull
    Optional<Category> findById(@NonNull Integer id);

    @Override
    @NonNull
    <S extends Category> S save(@NonNull S category);

    @Override
    boolean existsById(@NonNull Integer id);

    @Override
    void deleteById(@NonNull Integer id);

    // Optional custom method (example)
    Optional<Category> findByName(String name);

    boolean existsByName(String name);
}
