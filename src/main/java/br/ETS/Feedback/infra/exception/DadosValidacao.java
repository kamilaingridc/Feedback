package br.ETS.Feedback.infra.exception;

import org.springframework.validation.FieldError;

public record DadosValidacao (String field, String message){

    public DadosValidacao(FieldError fieldError){
        this(fieldError.getField(), fieldError.getDefaultMessage());
    }

}
