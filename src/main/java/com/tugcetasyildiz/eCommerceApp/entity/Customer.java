package com.tugcetasyildiz.eCommerceApp.entity;
import com.tugcetasyildiz.eCommerceApp.enums.EnumGender;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "CUSTOMER")
public class Customer {

    @SequenceGenerator(name = "customer", sequenceName = "CUSTOMER_ID_SEQ", allocationSize = 1)
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 50, nullable = false)
    private String surName;

    @CreatedDate
    @Column(name = "CREATE_DATE")
    @CreationTimestamp
    private LocalDateTime createDate;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER", length = 30)
    private EnumGender enumGender;

    @OneToMany
    private List<Invoice> invoiceList;

}