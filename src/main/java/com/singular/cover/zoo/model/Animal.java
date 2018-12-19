package com.singular.cover.zoo.model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * Object representing a animal.
 * 
 * @author mauro-sanchez
 */
public abstract class Animal {
	
	protected Long id;
	protected String name;
	protected String favoriteFood;
	protected Set<Friend> friends;
	
	protected Animal(Long id, String name, String favoriteFood) {
		Objects.requireNonNull(id, "id cannot be null");
		Objects.requireNonNull(name, "name cannot be null");
		Objects.requireNonNull(favoriteFood, "favorite food cannot be null");
		this.id = id;
		this.name = name;
		this.favoriteFood = favoriteFood;
		this.friends = new HashSet<Friend>();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFavoriteFood() {
		return favoriteFood;
	}

	public void setFavoriteFood(String favoriteFood) {
		this.favoriteFood = favoriteFood;
	}

	public Set<Friend> getFriends() {
		return friends;
	}

	public void setFriends(Set<Friend> friends) {
		this.friends = friends;
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
	    
        Animal animal = (Animal) obj;
        return id.equals(animal.getId());
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
    
    public String getData() {
    	String data = "\n\t- Name: " + name;
		data = data + "\n\t- Favorite food: " + favoriteFood;
		if (friends != null && !friends.isEmpty()) {
			data = data + "\n\t- Friends: ";
			Iterator<Friend> friendsIter = friends.iterator();
			while (friendsIter.hasNext()) {
				data = data + friendsIter.next().getAnimal().getName();
				if (friendsIter.hasNext()) data = data + ", ";
			}
		}
		else {
			data = data + "\n\t- Friends: Not has friends";
		}
		return data;
    }
}
