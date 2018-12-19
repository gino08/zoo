package com.singular.cover.zoo.ui;

import java.util.List;

import com.singular.cover.zoo.model.Animal;

/**
 * Interface for interaction with the user.
 *
 * @author mauro-sanchez
 */
public interface ZooUI {

	void initZoo();
	
	void listAnimalsZoo(List<Animal> animals);
	
	void printMessage(String change);
	
	void exitZoo();
	
	void showOptions();
	
	int getSelectedOption();
}
