package com.singular.cover.zoo.dao.typeHandler;

import com.singular.cover.zoo.model.SpeakType;

/**
 * TypeHandler for mapping java SpeakType Enum from String
 * 
 * @author mauro-sanchez
 */
public final class SpeakTypeHandler {

	public static final SpeakType valueOf(String value) {
		if (value == null) return null;
		
		switch (value) {
		case "CAN_SPEAK":
			return SpeakType.CAN_SPEAK;
		case "CAN_NOT_SPEAK":
			return SpeakType.CAN_NOT_SPEAK;
		default:
			throw new IllegalArgumentException("illegal value for SpeakType");
		}
	}
	
	public static final String valueOf(SpeakType value) {
		if (value == null) return null;
		
		switch (value) {
		case CAN_SPEAK:
			return "CAN_SPEAK";
		case CAN_NOT_SPEAK:
			return "CAN_NOT_SPEAK";
		default:
			throw new IllegalArgumentException("illegal value for value SpeakType");
		}
	}
}
