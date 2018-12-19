package com.singular.cover.zoo.model;

/**
 * Enum possible speak types.
 *
 * @author mauro-sanchez
 */
public enum SpeakType {

	CAN_SPEAK("CAN_SPEAK", "Can speak"), CAN_NOT_SPEAK("CAN_NOT_SPEAK", "Can not speak");

	private String code;
	private String description;

	private SpeakType(String code, String description) {
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
