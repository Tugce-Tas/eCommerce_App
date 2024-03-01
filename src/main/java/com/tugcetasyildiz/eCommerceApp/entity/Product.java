package com.tugcetasyildiz.eCommerceApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {
    @SequenceGenerator(name = "product", sequenceName = "PRODUCT_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @ManyToMany
    private List<Invoice> invoiceList;

    private Double price;
}
