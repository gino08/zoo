package com.singular.cover.zoo.model;

import java.util.Objects;

/**
 * Object representing a dog.
 * 
 * @author mauro-sanchez
 */
public final class Dog extends Animal {
	
	private String dogType;
	
	public Dog(Long id, String name, String favoriteFood, String dogType) {
		super(id, name, favoriteFood);
		Objects.requireNonNull(dogType, "dog type cannot be null");
		this.dogType = dogType;
	}

	public String getDogType() {
		return dogType;
	}

	public void setDogType(String dogType) {
		this.dogType = dogType;
	}

	@Override
	public String getData() {
		String data = new String(AnimalType.DOG.getDescription());
		data = data + super.getData();
		data = data + "\n\t- Dog Type: " + dogType;
		data = data + "\n\n";
		return data;
	}

}
