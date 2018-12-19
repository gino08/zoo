package com.singular.cover.zoo.model;

import java.util.Objects;

/**
 * Object representing a bird.
 * 
 * @author mauro-sanchez
 */
public abstract class Bird extends Animal {
	
	protected Double lengthOfWings;
	
	protected Bird(Long id, String name, String favoriteFood, Double lengthOfWings) {
		super(id, name, favoriteFood);
		Objects.requireNonNull(lengthOfWings, "length of wings cannot be null");
		this.lengthOfWings = lengthOfWings;
	}

	public Double getLengthOfWings() {
		return lengthOfWings;
	}

	public void setLengthOfWings(Double lengthOfWings) {
		this.lengthOfWings = lengthOfWings;
	}
	
	@Override
	public String getData() {
    	String data = super.getData();
    	data = data + "\n\t- Length of wings: " + favoriteFood;
		return data;
    }
}
