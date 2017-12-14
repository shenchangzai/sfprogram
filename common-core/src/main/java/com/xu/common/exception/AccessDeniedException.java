package com.xu.common.exception;

/**
 * 拒绝访问异常
 */
public class AccessDeniedException extends RuntimeException {
	private static final long serialVersionUID = 8794305307034995639L;

	public AccessDeniedException(String msg) {
		super(msg);
	}

	public AccessDeniedException(String msg, Throwable t) {
		super(msg, t);
	}
}
