package com.singular.cover.zoo.dao;

import java.util.List;

import com.singular.cover.zoo.model.Animal;

/**
 * Interface manage animals in files.
 *
 * @author mauro-sanchez
 */
public interface AnimalFileDao {
	
	List<Animal> load(String path);
	
	boolean isExistAnimals(String path);
	
	void createInitialAnimals(String pathFrom, String pathTo);
}
