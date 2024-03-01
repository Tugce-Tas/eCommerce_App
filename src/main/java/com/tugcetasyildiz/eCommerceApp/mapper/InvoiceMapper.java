package com.tugcetasyildiz.eCommerceApp.mapper;

import com.tugcetasyildiz.eCommerceApp.dto.InvoiceDTO;
import com.tugcetasyildiz.eCommerceApp.entity.Invoice;
import com.tugcetasyildiz.eCommerceApp.request.InvoiceSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InvoiceMapper {
    InvoiceMapper INSTANCE = Mappers.getMapper(InvoiceMapper.class);


    @Mapping(target = "productList", ignore = true)
    @Mapping(target = "companyId", ignore = true)
    @Mapping(target = "customerId", ignore = true)
    //@BeanMapping(ignoreUnmappedSourceProperties = { "productList" , "companyId", "customerId"})
    Invoice convertToInvoice(InvoiceSaveRequest invoiceSaveRequest);

    @Mapping(target = "productList", ignore = true)
    @Mapping(target = "companyName", ignore = true)
    @Mapping(target = "customerName", ignore = true)
    @Mapping(target = "customerSurname", ignore = true)
    InvoiceDTO convertToInvoiceDTO(Invoice invoice);
    List<InvoiceDTO> convertToInvoiceDTOs(List<Invoice> invoiceList);
}
