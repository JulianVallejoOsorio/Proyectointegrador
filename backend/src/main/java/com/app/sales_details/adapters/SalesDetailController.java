package com.app.sales_details.adapters;

import com.app.sales_details.domain.SalesDetail;
import com.app.sales_details.domain.ISalesDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-details")
public class SalesDetailController {

    private final ISalesDetailService salesDetailService;

    public SalesDetailController(ISalesDetailService salesDetailService) {
        this.salesDetailService = salesDetailService;
    }

    // Obtener todos los detalles de venta
    @GetMapping
    public ResponseEntity<List<SalesDetail>> getAllSalesDetails() {
        List<SalesDetail> salesDetails = salesDetailService.findAll();
        return ResponseEntity.ok(salesDetails);
    }

    // Obtener un detalle por ID
    @GetMapping("/{id}")
    public ResponseEntity<SalesDetail> getSalesDetailById(@PathVariable Long id) {
        SalesDetail salesDetail = salesDetailService.findById(id);
        return ResponseEntity.ok(salesDetail);
    }

    // Crear un nuevo detalle de venta
    @PostMapping
    public ResponseEntity<SalesDetail> createSalesDetail(@RequestBody SalesDetail salesDetail) {
        SalesDetail newDetail = salesDetailService.save(salesDetail);
        return ResponseEntity.ok(newDetail);
    }

    // Actualizar un detalle de venta
    @PutMapping("/{id}")
    public ResponseEntity<SalesDetail> updateSalesDetail(@PathVariable Long id, @RequestBody SalesDetail salesDetail) {
        SalesDetail updatedDetail = salesDetailService.update(salesDetail, id);
        return ResponseEntity.ok(updatedDetail);
    }

    // Eliminar un detalle de venta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesDetail(@PathVariable Long id) {
        salesDetailService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
