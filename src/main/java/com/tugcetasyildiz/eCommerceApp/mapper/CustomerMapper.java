package com.tugcetasyildiz.eCommerceApp.mapper;

import com.tugcetasyildiz.eCommerceApp.dto.CustomerDTO;
import com.tugcetasyildiz.eCommerceApp.entity.Customer;
import com.tugcetasyildiz.eCommerceApp.request.CustomerSaveRequest;
import com.tugcetasyildiz.eCommerceApp.request.CustomerUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer convertToCustomer(CustomerSaveRequest customerSaveRequest);
    Customer convertToCustomer(CustomerUpdateRequest customerUpdateRequest);
    CustomerDTO convertToCustomerDTO(Customer customer);
    List<CustomerDTO> convertToCustomerDTOs(List<Customer> customerList);


}
