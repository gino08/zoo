package com.singular.cover.zoo.dao.typeHandler;

import com.singular.cover.zoo.model.BroilerType;
import com.singular.cover.zoo.model.SpeakType;

/**
 * TypeHandler for mapping java BroilerType Enum from String
 * 
 * @author mauro-sanchez
 */
public final class BroilerTypeHandler {

	public static final BroilerType valueOf(String value) {
		if (value == null) return null;
		
		switch (value) {
		case "BROILER":
			return BroilerType.BROILER;
		case "NOT_BROILER":
			return BroilerType.NOT_BROILER;
		default:
			throw new IllegalArgumentException("illegal value for BroilerType");
		}
	}
	
	public static final String valueOf(BroilerType value) {
		if (value == null) return null;
		
		switch (value) {
		case BROILER:
			return "BROILER";
		case NOT_BROILER:
			return "NOT_BROILER";
		default:
			throw new IllegalArgumentException("illegal value for value BroilerType");
		}
	}
}
