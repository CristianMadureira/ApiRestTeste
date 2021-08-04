package com.example.ApiRestTest.handler;

import java.util.List;

public class FieldObjectError {

    private List<String> errors;

    public FieldObjectError(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }

    public String getMessage() {
        return "Ocorreu erros na validação!";
    }



}
