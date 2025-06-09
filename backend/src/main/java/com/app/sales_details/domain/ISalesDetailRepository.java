package com.app.sales_details.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalesDetailRepository extends JpaRepository<SalesDetail, Long> {

    @Override
    @NonNull
    List<SalesDetail> findAll();

    @Override
    @NonNull
    Optional<SalesDetail> findById(@NonNull Long id);

    @Override
    @NonNull
    <S extends SalesDetail> S save(@NonNull S salesDetail);

    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);


}
