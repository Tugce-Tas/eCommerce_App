package com.tugcetasyildiz.eCommerceApp.dao;

import com.tugcetasyildiz.eCommerceApp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("select c from Customer c where c.name like %:targetWord% or c.surName like %:targetWord% ")
    List<Customer> findAllByTargetWord(@Param("targetWord") String targetWord);
}
