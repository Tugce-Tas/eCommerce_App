package com.tugcetasyildiz.eCommerceApp.service;

import com.tugcetasyildiz.eCommerceApp.dao.CompanyRepository;
import com.tugcetasyildiz.eCommerceApp.dao.InvoiceRepository;
import com.tugcetasyildiz.eCommerceApp.dto.CompanyDTO;
import com.tugcetasyildiz.eCommerceApp.entity.Company;
import com.tugcetasyildiz.eCommerceApp.entity.Invoice;
import com.tugcetasyildiz.eCommerceApp.enums.EnumSector;
import com.tugcetasyildiz.eCommerceApp.mapper.CompanyMapper;
import com.tugcetasyildiz.eCommerceApp.request.CompanySaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final InvoiceRepository invoiceRepository;
    public List<CompanyDTO> getAllCompanies() {
        return CompanyMapper.INSTANCE.convertToCompanyDTOs(companyRepository.findAll());
    }

    public List<EnumSector> getSectorsOfCompaniesByDateAndInvoiceAverage(LocalDate startDate, LocalDate endDate, Double averagePrice) {

        Set<EnumSector> uniqueSectors = new HashSet<>();

        companyRepository.findAll().forEach(company -> {
            List<Invoice> invoicesByDate = invoiceRepository.findAllByCompanyIdAndCreateDateBetween(company.getId(), startDate, endDate);
            if (invoicesByDate.isEmpty()) {
                return;
            }

            double average = invoicesByDate.stream()
                    .mapToDouble(Invoice::getTotalPrice)
                    .average()
                    .orElse(0.0);
            if (average <= averagePrice) {
                   uniqueSectors.add(company.getSector());
            }
        });

        return new ArrayList<>(uniqueSectors);
    }

    public Company saveCompany(CompanySaveRequest request) {
        return companyRepository.save(CompanyMapper.INSTANCE.convertToCompany(request));
    }

    public void deleteCompany(Long companyId) {
        companyRepository.deleteById(companyId);
    }
}
