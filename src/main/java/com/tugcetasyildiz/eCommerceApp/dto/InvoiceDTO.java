package com.tugcetasyildiz.eCommerceApp.dto;

import java.util.List;

public record InvoiceDTO(String companyName,
                         String customerName,
                         String customerSurname,
                         List<ProductDTO> productList,
                         Double totalPrice) {
}
