package com.tugcetasyildiz.eCommerceApp.dao;

import com.tugcetasyildiz.eCommerceApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
