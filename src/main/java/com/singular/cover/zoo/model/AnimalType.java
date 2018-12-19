package com.singular.cover.zoo.model;

/**
 * Enum possible animal types.
 *
 * @author mauro-sanchez
 */
public enum AnimalType {

	DOG("DOG", "Dog"), PARROT("PARROT", "Parrot"), CHICKEN("CHICKEN", "Chicken");

	private String code;
	private String description;

	private AnimalType(String code, String description) {
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
