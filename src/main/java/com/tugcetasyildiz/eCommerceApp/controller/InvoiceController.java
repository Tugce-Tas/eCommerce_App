package com.tugcetasyildiz.eCommerceApp.controller;

import com.tugcetasyildiz.eCommerceApp.dto.InvoiceDTO;
import com.tugcetasyildiz.eCommerceApp.entity.Invoice;
import com.tugcetasyildiz.eCommerceApp.mapper.InvoiceMapper;
import com.tugcetasyildiz.eCommerceApp.request.InvoiceSaveRequest;
import com.tugcetasyildiz.eCommerceApp.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/invoices")
public class InvoiceController {
    private final InvoiceService invoiceService;
    private InvoiceMapper invoiceMapper;

    @PostMapping
    public Invoice createOrder(@RequestBody InvoiceSaveRequest request) {
        return invoiceService.createOrder(request);
    }

    @GetMapping
    public List<InvoiceDTO> getAllInvoices () {
        return invoiceService.getAllInvoices();
    }

    @GetMapping("/over/{price}")
    public List<InvoiceDTO> getInvoicesByTotalPriceIsGreaterThan (@PathVariable Double price) {
        return invoiceService.getInvoicesByTotalPriceIsGreaterThan(price);
    }

    @GetMapping("/over/{price}/average")
    public Double calculateAverageByPriceIsGreaterThan (@PathVariable Double price) {
        return invoiceService.calculateAverageByPriceIsGreaterThan(price);
    }
    @DeleteMapping("/{invoiceId}")
    public void invoiceService (@PathVariable Long invoiceId) {
        invoiceService.deleteInvoice(invoiceId) ;
    }
}
