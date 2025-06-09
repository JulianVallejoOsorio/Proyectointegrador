package com.app.sales_details.infrastructure;

import com.app.sales_details.domain.ISalesDetailRepository;
import com.app.sales_details.domain.SalesDetail;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SalesDetailDatasource {

    private final ISalesDetailRepository repository;

    public SalesDetailDatasource(ISalesDetailRepository repository) {
        this.repository = repository;
    }

    public List<SalesDetail> findAll() {
        return repository.findAll();
    }

    public Optional<SalesDetail> findById(Long id) {
        return repository.findById(id);
    }

    public SalesDetail save(SalesDetail detail) {
        return repository.save(detail);
    }

    public Optional<SalesDetail> update(SalesDetail detail, Long id) {
        return repository.findById(id).map(existing -> {
            existing.setSaleId(detail.getSaleId());
            existing.setProductId(detail.getProductId());
            existing.setQuantity(detail.getQuantity());
            existing.setPrice(detail.getPrice());
            return repository.save(existing);
        });
    }

    public boolean deleteById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
