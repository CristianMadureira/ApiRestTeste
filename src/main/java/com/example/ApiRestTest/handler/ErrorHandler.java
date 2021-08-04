package com.example.ApiRestTest.handler;

import com.example.ApiRestTest.exceptions.NewAddresseRegisterException;
import com.example.ApiRestTest.exceptions.NewUserRegisterException;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        final List<String> errors = new ArrayList<>();
        for (final FieldError error: ex.getBindingResult().getFieldErrors()){
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for(final ObjectError error: ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }
        return handleExceptionInternal(ex, new FieldObjectError(errors), headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(NewUserRegisterException.class)
    public final ResponseEntity<ErrorMessageResponse> handleNewUserException(NewUserRegisterException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorMessageResponse(ex.getMessage()), ex.getErrorCode());
    }

    @ExceptionHandler(NewAddresseRegisterException.class)
        public final ResponseEntity<ErrorMessageResponse> handleNewAddresseException(NewAddresseRegisterException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorMessageResponse(ex.getMessage()), ex.getErrorCode());
    }



}
