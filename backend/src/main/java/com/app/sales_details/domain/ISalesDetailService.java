package com.app.sales_details.domain;

import java.util.List;

public interface ISalesDetailService {

    List<SalesDetail> findAll();

    SalesDetail findById(Long id);

    SalesDetail save(SalesDetail salesDetail);

    SalesDetail update(SalesDetail salesDetail, Long id);

    void deleteById(Long id);
}
