package com.tugcetasyildiz.eCommerceApp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "INVOICE")
public class Invoice {
    @SequenceGenerator(name = "invoice", sequenceName = "INVOICE_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "invoice")
    @Column(name = "ID")
    private Long id;

    private Long companyId;

    private Long customerId;

    @ManyToMany
    private ArrayList<Product> productList;

    private Double totalPrice;

    private LocalDateTime createDate;
}
