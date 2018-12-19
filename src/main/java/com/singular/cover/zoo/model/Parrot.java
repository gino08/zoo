package com.singular.cover.zoo.model;

import java.util.Objects;

/**
 * Object representing a parrot.
 * 
 * @author mauro-sanchez
 */
public final class Parrot extends Bird {
	
	private SpeakType speak;
	
	public Parrot(Long id, String name, String favoriteFood, Double lengthOfWings, SpeakType speak) {
		super(id, name, favoriteFood, lengthOfWings);
		Objects.requireNonNull(speak, "speak cannot be null");
		this.speak = speak;
	}

	public SpeakType getSpeak() {
		return speak;
	}

	public void setSpeak(SpeakType speak) {
		this.speak = speak;
	}

	@Override
	public String getData() {
		String data = new String(AnimalType.PARROT.getDescription());
		data = data + super.getData();
		data = data + "\n\t- Speak: " + speak.getDescription();
		data = data + "\n\n";
		return data;
	}

}
