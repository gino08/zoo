package com.singular.cover.zoo.ui;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.singular.cover.zoo.model.Animal;

/**
 * Implementation of the interface ZooUI.
 * use the system console.
 *
 * @author mauro-sanchez
 */
public class ZooUIConsole implements ZooUI {
	
	private final Scanner scanner;

    public ZooUIConsole() {
        scanner = new Scanner(System.in);
    }

	@Override
	public void initZoo() {
		System.out.println("\nZoo created.");
	}
	
	@Override
	public void listAnimalsZoo(List<Animal> animals) {
		System.out.println("\n");
		if (animals != null && !animals.isEmpty()) {
			animals.stream().forEach(animal -> {
	            System.out.println(animal.getData());
	        });
		}
		else {
			System.out.println("\nNot animals found");
		}
	}
	
	@Override
	public void printMessage(String change) {
		System.out.println(change);
	}
	
	@Override
	public void exitZoo() {
		System.out.println("\n***************************************************");
    	System.out.println(".:                   Zoo close                   :.");
    	System.out.println("***************************************************\n");
	}
	
	public void showOptions() {
		System.out.println("\n-----------------------------------------");
		System.out.println("Select an option:\n");
		System.out.println("\t 1 - List all animals");
        System.out.println("\t 2 - Live one day");
        System.out.println("\t 3 - Exit");
        System.out.println("\n[SELECT OPTION AND PRESS ENTER TO READ THE NEXT OPTION]");
	}
	
	@Override
	public int getSelectedOption() {
		int selectedOption = 0;
		boolean read = true;
		while (read) {
			try {
				selectedOption = scanner.nextInt();
				if (invalidSelectedOption(selectedOption)) {
					System.out.println("Invalid value!");
				} else {
					read = false;
				}
			} catch (InputMismatchException e) {
			    System.out.println("Invalid value!");
			    scanner.next();
			} 
        }
        scanner.nextLine();
        return selectedOption;
	}
	
	private boolean invalidSelectedOption(int selectedOption) {
		return selectedOption != 1 && selectedOption != 2 && selectedOption != 3;
	}

}
