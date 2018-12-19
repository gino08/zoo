package com.singular.cover.zoo.model;

import java.util.Objects;

/**
 * Object representing a chicken.
 * 
 * @author mauro-sanchez
 */
public final class Chicken extends Bird {
	
	private BroilerType broiler;
	
	public Chicken(Long id, String name, String favoriteFood, Double lengthOfWings, BroilerType broiler) {
		super(id, name, favoriteFood, lengthOfWings);
		Objects.requireNonNull(broiler, "broiler cannot be null");
		this.broiler = broiler;
	}

	public BroilerType getBroiler() {
		return broiler;
	}

	public void setBroiler(BroilerType broiler) {
		this.broiler = broiler;
	}

	@Override
	public String getData() {
		String data = new String(AnimalType.CHICKEN.getDescription());
		data = data + super.getData();
		data = data + "\n\t- Broiler: " + broiler.getDescription();
		data = data + "\n\n";
		return data;
	}

}
