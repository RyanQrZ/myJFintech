package com.model.domain.enums;

/*
 * This section contains the possible errors with massage and code
 */

public enum ErrorEnum {
	
	ON0123("ID NUMBER ERROR", "ON-0123"),
	
	TR0127("SELLER CANNOT TRANSFER MONEY", "TR-0127"),
	TR0128("INSUFFICIENT BALANCE", "TR-0128");
	
	private String message, code;
	
	private ErrorEnum(String message, String code) {
		this.message = message;
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getCode() {
		return code;
	}

}
