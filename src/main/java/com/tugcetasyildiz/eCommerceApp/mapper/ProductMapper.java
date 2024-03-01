package com.tugcetasyildiz.eCommerceApp.mapper;

import com.tugcetasyildiz.eCommerceApp.dto.ProductDTO;
import com.tugcetasyildiz.eCommerceApp.entity.Product;
import com.tugcetasyildiz.eCommerceApp.request.ProductSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product convertToProduct(ProductSaveRequest productSaveRequest);
    ProductDTO convertToProductDTO(Product product);
    List<ProductDTO> convertToProductDTOs(List<Product> productList);


}
