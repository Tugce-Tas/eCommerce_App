package com.tugcetasyildiz.eCommerceApp.exceptionHandling;

import com.tugcetasyildiz.eCommerceApp.exceptionHandling.exception.*;
import com.tugcetasyildiz.eCommerceApp.exceptionHandling.message.GeneralErrorMessages;
import org.springframework.http.HttpStatus;
import com.tugcetasyildiz.eCommerceApp.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class GeneralControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleAllExceptions(Exception e, WebRequest request){
        String message = e.getMessage();
        String description = request.getDescription(false);

        var generalErrorMessage = new GeneralErrorMessages(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(generalErrorMessage);

        return new ResponseEntity<>(restResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleRTException(ItemNotFoundException e, WebRequest request) {
        String message = e.getMessage();
        String description = request.getDescription(false);

        var exception = new GeneralErrorMessages(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(exception);

        return new ResponseEntity<>(restResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleRTException(InvalidCompanyIdException e, WebRequest request) {
        String message = e.getLocalizedMessage();
        String description = request.getDescription(false);

        var exception = new GeneralErrorMessages(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(exception);

        return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleRTException(InvalidCustomerIdException e, WebRequest request) {
        String message = e.getLocalizedMessage();
        String description = request.getDescription(false);

        var exception = new GeneralErrorMessages(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(exception);

        return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleRTException(InvalidProductIdException e, WebRequest request) {
        String message = e.getLocalizedMessage();
        String description = request.getDescription(false);

        var exception = new GeneralErrorMessages(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(exception);

        return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler
    public final ResponseEntity<Object> handleRTException(BusinessException e, WebRequest request) {
        String message = e.getMessage();
        String description = request.getDescription(false);

        var exception = new GeneralErrorMessages(LocalDateTime.now(), message, description);
        var restResponse = RestResponse.error(exception);

        return new ResponseEntity<>(restResponse, HttpStatus.BAD_REQUEST);
    }


}
