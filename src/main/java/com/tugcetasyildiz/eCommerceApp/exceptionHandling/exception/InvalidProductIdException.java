package com.tugcetasyildiz.eCommerceApp.exceptionHandling.exception;

import com.tugcetasyildiz.eCommerceApp.exceptionHandling.message.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidProductIdException extends BusinessException {
    public InvalidProductIdException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
