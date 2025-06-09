package com.app.sales.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.sales.domain.ISaleRepository;
import com.app.sales.domain.Sale;

@Component
public class SaleDatasource {

    private final ISaleRepository saleRepository;

    public SaleDatasource(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    public Optional<Sale> findById(Integer id) {
        return saleRepository.findById(id);
    }

    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    public Optional<Sale> update(Sale sale, Integer id) {
        return saleRepository.findById(id).map(existingSale -> {
            existingSale.setUser(sale.getUser());
            existingSale.setDate(sale.getDate());
            existingSale.setTotal(sale.getTotal());
            return saleRepository.save(existingSale);
        });
    }

    public boolean deleteById(Integer id) {
        if (saleRepository.existsById(id)) {
            saleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
