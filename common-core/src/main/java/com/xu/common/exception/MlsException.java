package com.xu.common.exception;

/**
 * 通用异常类
 * @author 194129
 *
 */
public class MlsException extends Exception {

	private static final long serialVersionUID = 1123123123222L;

	public MlsException() {
	}

	public MlsException(String message, Throwable cause) {
		super(message, cause);
	}

	public MlsException(String message) {
		super(message);
	}

	public MlsException(Throwable cause) {
		super(cause);
	}
}