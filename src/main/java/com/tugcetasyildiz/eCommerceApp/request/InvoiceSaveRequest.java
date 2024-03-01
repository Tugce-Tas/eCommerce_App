package com.tugcetasyildiz.eCommerceApp.request;

import java.util.HashMap;

public record InvoiceSaveRequest(Long companyId,

                                 Long customerId,

                                 HashMap<Long, Integer> productList

                                 ) {
}
