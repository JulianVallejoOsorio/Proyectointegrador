package com.app.sales.infrastructure;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SaleDto {

    private Integer id;
    private Long userId;         // solo el id del usuario, no el objeto completo
    private LocalDateTime date;
    private BigDecimal total;

    // Constructor vacío
    public SaleDto() {
    }

    // Constructor con parámetros
    public SaleDto(Integer id, Long userId, LocalDateTime date, BigDecimal total) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.total = total;
    }

    // Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SaleDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", total=" + total +
                '}';
    }
}
