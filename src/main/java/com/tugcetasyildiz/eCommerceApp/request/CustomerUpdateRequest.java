package com.tugcetasyildiz.eCommerceApp.request;

import java.time.LocalDate;

public record CustomerUpdateRequest(String name,
                                    String surName,
                                    LocalDate birthDate,
                                    String email
                                    ) {
}
