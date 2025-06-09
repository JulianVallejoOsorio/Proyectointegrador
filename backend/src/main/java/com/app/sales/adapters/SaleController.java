package com.app.sales.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.sales.domain.ISaleService;
import com.app.sales.domain.Sale;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final ISaleService saleService;

    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    // Obtener todas las ventas
    @GetMapping
    public ResponseEntity<List<Sale>> getAllSales() {
        List<Sale> sales = saleService.findAll();
        return ResponseEntity.ok(sales);
    }

    // Obtener venta por id
    @GetMapping("/{id}")
    public ResponseEntity<Sale> getSaleById(@PathVariable Integer id) {
        Sale sale = saleService.findById(id);
        return ResponseEntity.ok(sale);
    }

    // Crear una venta
    @PostMapping
    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
        Sale newSale = saleService.save(sale);
        return ResponseEntity.ok(newSale);
    }

    // Actualizar una venta
    @PutMapping("/{id}")
    public ResponseEntity<Sale> updateSale(@PathVariable Integer id, @RequestBody Sale sale) {
        Sale updatedSale = saleService.update(sale, id);
        return ResponseEntity.ok(updatedSale);
    }

    // Eliminar una venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable Integer id) {
        saleService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
