package com.tugcetasyildiz.eCommerceApp.controller;

import com.tugcetasyildiz.eCommerceApp.RestResponse;
import com.tugcetasyildiz.eCommerceApp.dto.CompanyDTO;
import com.tugcetasyildiz.eCommerceApp.enums.EnumSector;
import com.tugcetasyildiz.eCommerceApp.mapper.CompanyMapper;
import com.tugcetasyildiz.eCommerceApp.request.CompanySaveRequest;
import com.tugcetasyildiz.eCommerceApp.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {
    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<RestResponse<List<CompanyDTO>>> getAllCompanies () {
        return ResponseEntity.ok(RestResponse.of(companyService.getAllCompanies()));
    }

    @GetMapping("/{averagePrice}")
    public ResponseEntity<RestResponse<List<EnumSector>>> getSectorsOfCompaniesByDateAndInvoiceAverage (@RequestParam LocalDate startDate, @RequestParam LocalDate endDate, @PathVariable Double averagePrice) {
        var sectors = companyService.getSectorsOfCompaniesByDateAndInvoiceAverage (startDate, endDate, averagePrice);
        return ResponseEntity.ok(RestResponse.of(sectors));
    }

    @PostMapping
    public ResponseEntity<RestResponse<CompanyDTO>> saveCompany (@RequestBody CompanySaveRequest request ) {
        var companyEntity = CompanyMapper.INSTANCE.convertToCompany(request);
        var companyDTO = CompanyMapper.INSTANCE.convertToCompanyDTO(companyEntity);
        return ResponseEntity.ok(RestResponse.of(companyDTO)) ;
    }

    @DeleteMapping("/{companyId}")
    public void deleteCompany (@PathVariable Long companyId) {
        companyService.deleteCompany(companyId) ;
    }

}
