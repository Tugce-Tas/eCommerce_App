package com.tugcetasyildiz.eCommerceApp.dto;

import java.time.LocalDate;

public record CustomerDTO(String name,
                          String surName,
                          LocalDate birthDate) {
}
