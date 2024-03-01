package com.tugcetasyildiz.eCommerceApp.service;

import com.tugcetasyildiz.eCommerceApp.dao.CustomerRepository;
import com.tugcetasyildiz.eCommerceApp.dao.InvoiceRepository;
import com.tugcetasyildiz.eCommerceApp.dto.CustomerDTO;
import com.tugcetasyildiz.eCommerceApp.entity.Invoice;
import com.tugcetasyildiz.eCommerceApp.mapper.CustomerMapper;
import com.tugcetasyildiz.eCommerceApp.request.CustomerSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final InvoiceService invoiceService;
    private final CustomerRepository customerRepository;
    private final InvoiceRepository invoiceRepository;

    public CustomerDTO save(CustomerSaveRequest request) {
        var entity = CustomerMapper.INSTANCE.convertToCustomer(request);
        return CustomerMapper.INSTANCE.convertToCustomerDTO(customerRepository.save(entity));
    }
    public List<CustomerDTO> getAllCustomers() {
        return CustomerMapper.INSTANCE.convertToCustomerDTOs(customerRepository.findAll());
    }

    public List<CustomerDTO> getCustomersByTargetWord(String targetWord) {
        return CustomerMapper.INSTANCE.convertToCustomerDTOs(customerRepository.findAllByTargetWord(targetWord));
    }

    public List<CustomerDTO> getCustomersByInvoiceAmountLessThan(Double price) {
        List<Invoice> invoicesByPriceIsLessThan = invoiceRepository.findInvoicesByTotalPriceIsLessThan(price);

        List<Long> customerIdList = invoicesByPriceIsLessThan.stream()
                .map(Invoice::getCustomerId)
                .toList();

        return CustomerMapper.INSTANCE.convertToCustomerDTOs(customerRepository.findAllById(customerIdList));
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
