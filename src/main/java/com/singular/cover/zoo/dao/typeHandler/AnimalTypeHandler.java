package com.singular.cover.zoo.dao.typeHandler;

import com.singular.cover.zoo.model.AnimalType;

/**
 * TypeHandler for mapping java AnimalType Enum from String
 * 
 * @author mauro-sanchez
 */
public final class AnimalTypeHandler {

	public static final AnimalType valueOf(String value) {
		if (value == null) return null;
		
		switch (value) {
		case "DOG":
			return AnimalType.DOG;
		case "PARROT":
			return AnimalType.PARROT;
		case "CHICKEN":
			return AnimalType.CHICKEN;
		default:
			throw new IllegalArgumentException("illegal value for AnimalType");
		}
	}
	
	public static final String valueOf(AnimalType value) {
		if (value == null) return null;
		
		switch (value) {
		case DOG:
			return "DOG";
		case PARROT:
			return "PARROT";
		case CHICKEN:
			return "CHICKEN";
		default:
			throw new IllegalArgumentException("illegal value for value AnimalType");
		}
	}
}
