/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acp.logback4gx;

/**
 *
 * @author sebastian
 */

public enum Logback4GXErrorEnum {
	NOERROR((short)0,""),
	UNKNOWN_ERROR((short)9000, "Unknown error");
	
	private final short code;
	private final String description;

	private Logback4GXErrorEnum(short code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getFormatedExtraDescription(String extraDescription) {
		return description + ": " + extraDescription;
	}
	
	public short getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code + ": " + description;
	}	
}
