package com.tugcetasyildiz.eCommerceApp.dao;

import com.tugcetasyildiz.eCommerceApp.entity.Company;
import com.tugcetasyildiz.eCommerceApp.entity.Customer;
import com.tugcetasyildiz.eCommerceApp.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
