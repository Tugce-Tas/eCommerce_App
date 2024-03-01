package com.tugcetasyildiz.eCommerceApp.service;

import com.tugcetasyildiz.eCommerceApp.dao.InvoiceRepository;
import com.tugcetasyildiz.eCommerceApp.dao.ProductRepository;
import com.tugcetasyildiz.eCommerceApp.dto.ProductDTO;
import com.tugcetasyildiz.eCommerceApp.mapper.ProductMapper;
import com.tugcetasyildiz.eCommerceApp.request.ProductSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final InvoiceRepository invoiceRepository;
    public List<ProductDTO> getAllProducts() {
        return ProductMapper.INSTANCE.convertToProductDTOs(productRepository.findAll());
    }

    public ProductDTO saveProduct(ProductSaveRequest request) {
        var entity = ProductMapper.INSTANCE.convertToProduct(request);
        var savedEntity = productRepository.save(entity);
        return ProductMapper.INSTANCE.convertToProductDTO(savedEntity);
    }

    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
