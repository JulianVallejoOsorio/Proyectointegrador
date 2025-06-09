package com.app.sales_details.application;

import com.app.sales_details.domain.ISalesDetailService;
import com.app.sales_details.domain.ISalesDetailRepository;
import com.app.sales_details.domain.SalesDetail;
import com.app.shared.adapters.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalesDetailService implements ISalesDetailService {

    private final ISalesDetailRepository repository;

    public SalesDetailService(ISalesDetailRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SalesDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public SalesDetail findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SalesDetail not found with ID: " + id));
    }

    @Override
    @Transactional
    public SalesDetail save(SalesDetail detail) {
        // aquí puedes agregar validaciones si quieres
        return repository.save(detail);
    }

    @Override
    @Transactional
    public SalesDetail update(SalesDetail detail, Long id) {
        SalesDetail existing = findById(id);
        existing.setSaleId(detail.getSaleId());
        existing.setProductId(detail.getProductId());
        existing.setQuantity(detail.getQuantity());
        existing.setPrice(detail.getPrice());
        return repository.save(existing);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        SalesDetail existing = findById(id);
        repository.delete(existing);
    }
}
