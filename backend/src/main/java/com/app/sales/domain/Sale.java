package com.app.sales.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Relación ManyToOne con User, usando user_id en la tabla sales
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private com.app.users.domain.User user;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    // Constructor vacío para JPA
    public Sale() {}

    // Constructor con parámetros
    public Sale(Integer id, com.app.users.domain.User user, LocalDateTime date, BigDecimal total) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.total = total;
    }

    // Getters y setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.app.users.domain.User getUser() {
        return user;
    }

    public void setUser(com.app.users.domain.User user) {
        this.user = user;
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
}
