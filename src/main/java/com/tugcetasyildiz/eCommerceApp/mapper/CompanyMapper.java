package com.tugcetasyildiz.eCommerceApp.mapper;

import com.tugcetasyildiz.eCommerceApp.dto.CompanyDTO;
import com.tugcetasyildiz.eCommerceApp.dto.CustomerDTO;
import com.tugcetasyildiz.eCommerceApp.entity.Company;
import com.tugcetasyildiz.eCommerceApp.entity.Customer;
import com.tugcetasyildiz.eCommerceApp.request.CompanySaveRequest;
import com.tugcetasyildiz.eCommerceApp.request.CustomerSaveRequest;
import com.tugcetasyildiz.eCommerceApp.request.CustomerUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {

    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    Company convertToCompany(CompanySaveRequest companySaveRequest);
    CompanyDTO convertToCompanyDTO(Company companyList);
    List<CompanyDTO> convertToCompanyDTOs(List<Company> companyList);
}
