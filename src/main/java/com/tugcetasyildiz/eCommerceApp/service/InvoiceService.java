package com.tugcetasyildiz.eCommerceApp.service;

import com.tugcetasyildiz.eCommerceApp.dao.CompanyRepository;
import com.tugcetasyildiz.eCommerceApp.dao.CustomerRepository;
import com.tugcetasyildiz.eCommerceApp.dao.InvoiceRepository;
import com.tugcetasyildiz.eCommerceApp.dao.ProductRepository;
import com.tugcetasyildiz.eCommerceApp.dto.InvoiceDTO;
import com.tugcetasyildiz.eCommerceApp.entity.Company;
import com.tugcetasyildiz.eCommerceApp.entity.Customer;
import com.tugcetasyildiz.eCommerceApp.entity.Invoice;
import com.tugcetasyildiz.eCommerceApp.entity.Product;
import com.tugcetasyildiz.eCommerceApp.exceptionHandling.exception.InvalidCompanyIdException;
import com.tugcetasyildiz.eCommerceApp.exceptionHandling.exception.InvalidCustomerIdException;
import com.tugcetasyildiz.eCommerceApp.exceptionHandling.message.EnumErrorMessage;
import com.tugcetasyildiz.eCommerceApp.mapper.InvoiceMapper;
import com.tugcetasyildiz.eCommerceApp.request.InvoiceSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;
    private final CompanyRepository companyRepository;
    public List<InvoiceDTO> getAllInvoices() {
        return InvoiceMapper.INSTANCE.convertToInvoiceDTOs(invoiceRepository.findAll());
    }
    public List<InvoiceDTO> getInvoicesByTotalPriceIsGreaterThan(Double price) {
       return InvoiceMapper.INSTANCE.convertToInvoiceDTOs(invoiceRepository.findAllByTotalPriceIsGreaterThan(price));
    }
    public Invoice createOrder(InvoiceSaveRequest request) {
        Customer customer = customerRepository.findById(request.customerId()).orElse(null);
        Company company = companyRepository.findById(request.companyId()).orElse(null);

        if (Objects.isNull(customer)) {
            throw new InvalidCustomerIdException(EnumErrorMessage.INVALID_CUSTOMER_ID);
        }
        if (Objects.isNull(company)) {
            throw new InvalidCompanyIdException(EnumErrorMessage.INVALID_COMPANY_ID);
        }

        double totalPrice = 0;
        ArrayList<Product> productList = new ArrayList<>();
        for (Map.Entry<Long, Integer> order : request.productList().entrySet()) {
            Long productId = order.getKey();
            int count = order.getValue();

            Product product = productRepository.findById(productId).orElse(null);
            if (Objects.isNull(product)) {
                throw new InvalidCompanyIdException(EnumErrorMessage.INVALID_PRODUCT_ID);
            }

            List<Product> productsToAdd = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                Product productToAdd = new Product();
                productToAdd.setName(product.getName());
                productsToAdd.add(productToAdd);
            }

            productList.addAll(productsToAdd);
            totalPrice += product.getPrice() * count;
        }

        Invoice entity = InvoiceMapper.INSTANCE.convertToInvoice(request);
        entity.setTotalPrice(totalPrice);
        entity.setCreateDate(LocalDateTime.now());
        entity.setProductList(productList);
        return invoiceRepository.save(entity);
    }

    public Double calculateAverageByPriceIsGreaterThan(Double price) {
        List<Invoice> allByPriceIsGreaterThan = invoiceRepository.findAllByTotalPriceIsGreaterThan(price);
        if(allByPriceIsGreaterThan.isEmpty()) {
            return 0.0;
        }

        return allByPriceIsGreaterThan.stream()
                .mapToDouble(Invoice::getTotalPrice)
                .average()
                .orElse(0.0);
    }

    public void deleteInvoice(Long invoiceId) {
        invoiceRepository.deleteById(invoiceId);
    }
}

