package com.tugcetasyildiz.eCommerceApp.request;

import com.tugcetasyildiz.eCommerceApp.enums.EnumSector;

public record CompanySaveRequest(String name,
                                 EnumSector sector
                                 ) {
}
