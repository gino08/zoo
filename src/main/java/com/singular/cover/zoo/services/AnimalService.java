package com.singular.cover.zoo.services;

import java.util.List;

import com.singular.cover.zoo.model.Animal;

/**
 * Interface load animals.
 *
 * @author mauro-sanchez
 */
public interface AnimalService {
	
	List<Animal> loadAllAnimals();
	
	public void setUpAnimals();
}
