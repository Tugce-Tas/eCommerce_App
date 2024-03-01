package com.tugcetasyildiz.eCommerceApp.exceptionHandling.message;

public enum EnumErrorMessage implements BaseErrorMessage{
    INVALID_CUSTOMER_ID("Customer is not found!"),
    INVALID_COMPANY_ID("Company is not found!"),
    INVALID_PRODUCT_ID("Product is not found!");

    private final String message;
    EnumErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
