package com.tugcetasyildiz.eCommerceApp.controller;

import com.tugcetasyildiz.eCommerceApp.RestResponse;
import com.tugcetasyildiz.eCommerceApp.dto.CustomerDTO;
import com.tugcetasyildiz.eCommerceApp.request.CustomerSaveRequest;
import com.tugcetasyildiz.eCommerceApp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<RestResponse<List<CustomerDTO>>> getAllCustomers () {
        return ResponseEntity.ok(RestResponse.of(customerService.getAllCustomers()));
    }

    @GetMapping("/filter/{targetWord}")
    public  ResponseEntity<RestResponse<List<CustomerDTO>>> getCustomersByTargetWord(@PathVariable String targetWord) {
        var customers = customerService.getCustomersByTargetWord(targetWord);
        return ResponseEntity.ok(RestResponse.of(customers));
    }
    @GetMapping("/by-invoice-amount/less-than/{price}")
    public  ResponseEntity<RestResponse<List<CustomerDTO>>> getCustomersByInvoiceAmountLessThan (@PathVariable Double price) {
        var customers = customerService.getCustomersByInvoiceAmountLessThan(price);
        return ResponseEntity.ok(RestResponse.of(customers));
    }

    @PostMapping
    public ResponseEntity<RestResponse<CustomerDTO>> saveCustomer(@RequestBody CustomerSaveRequest request) {
        return ResponseEntity.ok(RestResponse.of(customerService.save(request)));
    }

    @DeleteMapping("/{customerId}")
    public void customerService (@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId) ;
    }
}
