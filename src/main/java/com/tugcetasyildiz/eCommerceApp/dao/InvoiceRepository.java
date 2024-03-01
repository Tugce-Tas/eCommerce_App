package com.tugcetasyildiz.eCommerceApp.dao;

import com.tugcetasyildiz.eCommerceApp.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
   List<Invoice> findAllByTotalPriceIsGreaterThan(Double price);

    List<Invoice> findInvoicesByTotalPriceIsLessThan(Double price);

    List<Invoice> findAllByCompanyIdAndCreateDateBetween(Long companyId, LocalDate createDate, LocalDate createDate2);
}
