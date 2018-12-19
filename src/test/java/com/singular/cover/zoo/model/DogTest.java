package com.singular.cover.zoo.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mauro-sanchez
 */
public class DogTest {
	
	@Test(expected = NullPointerException.class)
	public void given_aNullId_when_createDog_then_nullPointerException() {
		new Dog(null, "name", "favoriteFood", "dogType");
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullName_when_createDog_then_nullPointerException() {
		new Dog(new Long(1), null, "favoriteFood", "dogType");
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullFavoriteFood_when_createDog_then_nullPointerException() {
		new Dog(new Long(1), "name", null, "dogType");
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullDogType_when_createDog_then_nullPointerException() {
		new Dog(new Long(1), "name", "favoriteFood", null);
	}
	
	@Test
	public void given_allData_when_createDog_then_createSuccess() {
		Assert.assertNotNull(new Dog(new Long(1), "name", "favoriteFood", "dogType"));
	}
	
	@Test
	public void given_aTwoDogsWithSameId_when_useEquals_then_returnTrue() {
		Dog dogOne = new Dog(new Long(1), "name1", "favoriteFood1", "dogType1");
		Dog dogTwo = new Dog(new Long(1), "name2", "favoriteFood2", "dogType2");
        Assert.assertTrue(dogOne.equals(dogTwo));
    }

    @Test
    public void given_aTwoDogsWithDifferentId_when_useEquals_then_returnFalse() {
    	Dog dogOne = new Dog(new Long(1), "name1", "favoriteFood1", "dogType1");
    	Dog dogTwo = new Dog(new Long(2), "name2", "favoriteFood2", "dogType2");
        Assert.assertFalse(dogOne.equals(dogTwo));
    }
    
}
