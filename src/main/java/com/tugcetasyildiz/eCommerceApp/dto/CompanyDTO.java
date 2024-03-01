package com.tugcetasyildiz.eCommerceApp.dto;

import com.tugcetasyildiz.eCommerceApp.enums.EnumSector;

import java.util.List;

public record CompanyDTO(String name,
                         EnumSector sector,
                         List<InvoiceDTO> invoiceList) {
}
