package com.app.products.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Override
    @NonNull
    List<Product> findAll();

    @Override
    @NonNull
    Optional<Product> findById(@NonNull Integer id);

    @Override
    @NonNull
    <S extends Product> S save(@NonNull S product);

    @Override
    boolean existsById(@NonNull Integer id);

    @Override
    void deleteById(@NonNull Integer id);

    // Aquí podrías agregar métodos específicos de productos si necesitas,
    // por ejemplo, buscar productos por nombre o categoría.
}
