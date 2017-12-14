package com.xu.common.exception;


import org.springframework.validation.FieldError;

import java.util.List;

/**
 * 参数异常
 */
public class ParameterErrorException extends RuntimeException {
	private static final long serialVersionUID = 8794305307034995639L;

	private List<FieldError> errors;

    private String description;

    public ParameterErrorException(String message) {
        super(message);
    }

    public ParameterErrorException(List<FieldError> errors) {
        super("");
        this.errors = errors;
    }

    public ParameterErrorException(String message, List<FieldError> errors, String description) {
        super(message);
        this.errors = errors;
        this.description = description;
    }

    public List<FieldError> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldError> errors) {
        this.errors = errors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
