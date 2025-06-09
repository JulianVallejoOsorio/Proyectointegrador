package com.app.sales.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Integer> {

    @Override
    @NonNull
    List<Sale> findAll();

    @Override
    @NonNull
    Optional<Sale> findById(@NonNull Integer id);

    @Override
    @NonNull
    <S extends Sale> S save(@NonNull S sale);

    @Override
    boolean existsById(@NonNull Integer id);

    @Override
    void deleteById(@NonNull Integer id);

}