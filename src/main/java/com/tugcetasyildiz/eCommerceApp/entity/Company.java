package com.tugcetasyildiz.eCommerceApp.entity;

import com.tugcetasyildiz.eCommerceApp.enums.EnumSector;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "COMPANY")
public class Company {
    @SequenceGenerator(name = "company", sequenceName = "COMPANY_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private EnumSector sector;

    @OneToMany
    private List<Invoice> invoiceList;
}
