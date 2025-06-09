package com.app.sales.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.sales.domain.ISaleRepository;
import com.app.sales.domain.ISaleService;
import com.app.sales.domain.Sale;

@Service
public class SaleService implements ISaleService {

    private final ISaleRepository saleRepository;

    public SaleService(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public Sale findById(Integer id) {
        return saleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sale not found with ID: " + id));
    }

    @Override
    @Transactional
    public Sale save(Sale sale) {
        // Si necesitas validaciones específicas las agregas aquí
        return saleRepository.save(sale);
    }

    @Override
    @Transactional
    public Sale update(Sale sale, Integer id) {
        Sale existingSale = findById(id);
        existingSale.setUser(sale.getUser());
        existingSale.setDate(sale.getDate());
        existingSale.setTotal(sale.getTotal());
        return saleRepository.save(existingSale);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Sale sale = findById(id);
        saleRepository.delete(sale);
    }
}
