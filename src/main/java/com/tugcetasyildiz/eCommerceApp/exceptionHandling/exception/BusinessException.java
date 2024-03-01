package com.tugcetasyildiz.eCommerceApp.exceptionHandling.exception;

import com.tugcetasyildiz.eCommerceApp.exceptionHandling.message.BaseErrorMessage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BusinessException extends RuntimeException {

    public BusinessException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage.getMessage());
    }
}