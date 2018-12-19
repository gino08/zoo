package com.singular.cover.zoo.model;

import java.util.Objects;

/**
 * Object representing a friend.
 * 
 * @author mauro-sanchez
 */
public final class Friend {
	
	private Animal animal;
	private Integer fromDay;
	
	public Friend(Animal animal, Integer fromDay) {
		Objects.requireNonNull(animal, "animal cannot be null");
		Objects.requireNonNull(fromDay, "fromDay cannot be null");
		this.setAnimal(animal);
		this.setFromDay(fromDay);
	}
	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Integer getFromDay() {
		return fromDay;
	}

	public void setFromDay(Integer fromDay) {
		this.fromDay = fromDay;
	}

	@Override
    public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
	        return true;
		}
	    if (obj.getClass() != getClass())
	        return false;
	    
        Friend animal = (Friend) obj;
        return this.animal.equals(animal.getAnimal());
    }

    @Override
    public int hashCode() {
        return animal.hashCode();
    }

}
