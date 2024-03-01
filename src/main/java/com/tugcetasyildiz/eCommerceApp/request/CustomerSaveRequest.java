package com.tugcetasyildiz.eCommerceApp.request;

import com.tugcetasyildiz.eCommerceApp.enums.EnumGender;

import java.time.LocalDate;

public record CustomerSaveRequest(String name,
                                  String surName,
                                  LocalDate birthDate,
                                  String email,
                                  EnumGender enumGender) {
}
