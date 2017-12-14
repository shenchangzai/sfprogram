package com.xu.common.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.validation.FieldError;

public class ParameterError extends FieldError {
	private static final long serialVersionUID = -8165797623413101149L;

	public ParameterError(String objectName, String field, String defaultMessage) {
        super(objectName, field, defaultMessage);
    }

    public ParameterError(String objectName, String field, Object rejectedValue, boolean bindingFailure, String[] codes, Object[] arguments, String defaultMessage) {
        super(objectName, field, rejectedValue, bindingFailure, codes, arguments, defaultMessage);
    }

    public ParameterError(FieldError fieldError) {
        super(fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue(), fieldError.isBindingFailure(), fieldError.getCodes(), fieldError.getArguments(), fieldError.getDefaultMessage());
    }

    @JsonIgnore
    @Override
    public String[] getCodes() {
        return super.getCodes();
    }

    @Override
    public String getCode() {
        return super.getCode();
    }

    @JsonIgnore
    @Override
    public Object[] getArguments() {
        return super.getArguments();
    }

    @Override
    public String getDefaultMessage() {
        return super.getDefaultMessage();
    }
}
