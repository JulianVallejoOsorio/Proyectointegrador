package com.app.sales.domain;

import java.util.List;

public interface ISaleService {

    List<Sale> findAll();

    Sale findById(Integer id);

    Sale save(Sale sale);

    Sale update(Sale sale, Integer id);

    void deleteById(Integer id);
}
