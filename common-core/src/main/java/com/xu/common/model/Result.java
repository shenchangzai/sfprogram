package com.xu.common.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 基础返回类型（Rest）
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {
	
	/**
	 * 
	 */
	private boolean success = true;
	
    /**
     * 编码
     */
    private String code;

    /**
     * 错误信息
     */
    private List<ParameterError> errors;

    /**
     * 信息
     */
    private String message;

    /**
     * 说明
     */
    private String description;

    /**
     * 数据信息
     */
    private Object data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<ParameterError> getErrors() {
        return errors;
    }

    public void setErrors(List<ParameterError> errors) {
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Result() {

    }

    public Result(Object details) {
        this.data = details;
    }

    public Result(String code, List<ParameterError> errors, String message) {
        this.code = code;
        this.errors = errors;
        this.message = message;
    }


    public Result(String code, String message, String description) {
    	this.success = false;
        this.code = code;
        this.message = message;
        this.description = description;
    }
    
    // for 1**
    public static Result succeed(Object details) {
        return new Result(details);
    }

    // for 2**
    public static Result error(String code, String message, String description) {
        return new Result(code, message, description);
    }
    
    // for 3**
    public static Result error(String code, String message) {
        return new Result(code, message, null);
    }

    // for 4**
    public static Result errorClient(String code, List<ParameterError> errors, String message) {
        return new Result(code, errors, message);
    }

    // for 5**
    public static Result errorServer(String code, String message, String description) {
        return new Result(code, message, description);
    }
       
}