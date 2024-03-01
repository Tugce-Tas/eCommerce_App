package com.tugcetasyildiz.eCommerceApp.controller;

import com.tugcetasyildiz.eCommerceApp.RestResponse;
import com.tugcetasyildiz.eCommerceApp.dto.CompanyDTO;
import com.tugcetasyildiz.eCommerceApp.dto.ProductDTO;
import com.tugcetasyildiz.eCommerceApp.enums.EnumSector;
import com.tugcetasyildiz.eCommerceApp.mapper.CompanyMapper;
import com.tugcetasyildiz.eCommerceApp.mapper.ProductMapper;
import com.tugcetasyildiz.eCommerceApp.request.CompanySaveRequest;
import com.tugcetasyildiz.eCommerceApp.request.ProductSaveRequest;
import com.tugcetasyildiz.eCommerceApp.service.CompanyService;
import com.tugcetasyildiz.eCommerceApp.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<RestResponse<List<ProductDTO>>> getAllProducts () {
        return ResponseEntity.ok(RestResponse.of(productService.getAllProducts()));
    }


    @PostMapping
    public ResponseEntity<RestResponse<ProductDTO>> saveProduct (@RequestBody ProductSaveRequest request ) {
        return ResponseEntity.ok(RestResponse.of(productService.saveProduct(request))) ;
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct (@PathVariable Long productId) {
        productService.deleteProduct(productId) ;
    }

}
