package com.singular.cover.zoo;

import java.util.List;
import java.util.Random;

import com.singular.cover.zoo.model.Animal;
import com.singular.cover.zoo.model.Friend;
import com.singular.cover.zoo.services.AnimalService;
import com.singular.cover.zoo.services.AnimalServiceFiles;
import com.singular.cover.zoo.ui.ZooUI;

/**
 * Implementation of the interface Zoo.
 * 
 * Maintains the state of the zoo.
 *
 * @author mauro-sanchez
 */
public class ZooImpl implements Zoo {
	
	private List<Animal> animals;
	private AnimalService animalService;
    private ZooUI zooUI;
    private int day;
    
    private ZooImpl() {
    }
    
    public static Zoo createZoo() {
        return new ZooImpl();
    }
    
	@Override
	public void initZoo(ZooUI zooUI) {
		setUpZoo();
		this.zooUI = zooUI;
		this.zooUI.initZoo();
		this.day = 0;
		
		int selectedOption = 0;
		while (selectedOption != 3) {
			this.zooUI.showOptions();
			selectedOption = this.zooUI.getSelectedOption();
			switch (selectedOption) {
			case 1:
				this.listAnimalsZoo();
				break;
			case 2:
				this.liveOneDayZoo();
				break;
			case 3:
				this.exitZoo();
				break;
			default:
				break;
			}
		}
	}
	
	@Override
	public void listAnimalsZoo() {
		this.zooUI.listAnimalsZoo(animals);
	}

	@Override
	public void liveOneDayZoo() {
		day = day + 1;
		if (animals != null && !animals.isEmpty()) {
			animals.stream().forEach(animal -> {
				String changesFriends = randomFriends(animal);
				if (changesFriends != null) this.zooUI.printMessage("\n\t" + changesFriends);
	        });
		}
	}
	
	@Override
	public void exitZoo() {
		this.animals.clear();
		this.zooUI.exitZoo();
	}
	
	private void setUpZoo() {
		this.animalService = new AnimalServiceFiles();
		this.animalService.setUpAnimals();
		this.animals = animalService.loadAllAnimals();
	}

	private String randomFriends(Animal animal) {
		String changesFriends = randomLostFriend(animal);
		
		String establishFriend = randomEstablishFriend(animal);
		if (establishFriend != null) {
			if (changesFriends != null) 
				changesFriends += "; ";
			else
				changesFriends = new String();
			changesFriends = changesFriends + establishFriend;
		}
		
		return changesFriends;
	}
	
	private String randomLostFriend(Animal animal) {
		if (animal.getFriends() != null && !animal.getFriends().isEmpty()) {
			Friend friend = (Friend) animal.getFriends().toArray()[new Random().nextInt(animal.getFriends().size())];
			if (friend.getFromDay().equals(new Integer(day))) {
				animal.getFriends().remove(friend);
				friend.getAnimal().getFriends().remove(new Friend(animal, friend.getFromDay()));
				return animal.getName() + " has lost friendship with " + friend.getAnimal().getName();
			}
		}
		
		return null;
	}
	
	private String randomEstablishFriend(Animal animal) {
		Friend friend = new Friend(animals.get(new Random().nextInt(animals.size())), day) ;
		if (!animal.getFriends().contains(friend) && !animal.equals(friend.getAnimal())) {
			animal.getFriends().add(friend);
			Friend friend2 = new Friend(animal, new Integer(day));
			friend.getAnimal().getFriends().add(friend2);
			return animal.getName() + " has established friendship with " + friend.getAnimal().getName();
		}
		
		return null;
	}
}
