package com.singular.cover.zoo.model;

/**
 * Enum possible broiler types.
 *
 * @author mauro-sanchez
 */
public enum BroilerType {

	BROILER("BROILER", "Broiler"), NOT_BROILER("NOT_BROILER", "Not a broiler");

	private String code;
	private String description;

	private BroilerType(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return this.code;
	}

	public String getDescription() {
		return this.description;
	}
	
}
