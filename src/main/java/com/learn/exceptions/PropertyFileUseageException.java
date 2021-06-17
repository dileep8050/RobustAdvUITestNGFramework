package com.learn.exceptions;

@SuppressWarnings("serial")
public class PropertyFileUseageException extends FrameworkException {

	public PropertyFileUseageException(String message) {
		super(message);
	}
	public PropertyFileUseageException(String message, Throwable cause) {
		super(message, cause);
	}

}
