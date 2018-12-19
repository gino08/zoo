package com.singular.cover.zoo.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mauro-sanchez
 */
public class ParrotTest {
	
	@Test(expected = NullPointerException.class)
	public void given_aNullId_when_createParrot_then_nullPointerException() {
		new Parrot(null, "name", "favoriteFood", new Double(1), SpeakType.CAN_SPEAK);
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullName_when_createParrot_then_nullPointerException() {
		new Parrot(new Long(1), null, "favoriteFood", new Double(1), SpeakType.CAN_SPEAK);
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullFavoriteFood_when_createParrot_then_nullPointerException() {
		new Parrot(new Long(1), "name", null, new Double(1), SpeakType.CAN_SPEAK);
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullLengthOfWings_when_createParrot_then_nullPointerException() {
		new Parrot(new Long(1), "name", "favoriteFood", null, SpeakType.CAN_SPEAK);
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullSpeak_when_createParrot_then_nullPointerException() {
		new Parrot(new Long(1), "name", "favoriteFood", new Double(1), null);
	}
	
	@Test
	public void given_allData_when_createParrot_then_createSuccess() {
		Assert.assertNotNull(new Parrot(new Long(1), "name", "favoriteFood", new Double(1), SpeakType.CAN_SPEAK));
	}
	
	@Test
	public void given_aTwoParrotsWithSameId_when_useEquals_then_returnTrue() {
		Parrot parrotOne = new Parrot(new Long(1), "name1", "favoriteFood1", new Double(1), SpeakType.CAN_SPEAK);
		Parrot parrotTwo = new Parrot(new Long(1), "name2", "favoriteFood2", new Double(2), SpeakType.CAN_SPEAK);
        Assert.assertTrue(parrotOne.equals(parrotTwo));
    }

    @Test
    public void given_aTwoParrotsWithDifferentId_when_useEquals_then_returnFalse() {
    	Parrot parrotOne = new Parrot(new Long(1), "name1", "favoriteFood1", new Double(1), SpeakType.CAN_SPEAK);
		Parrot parrotTwo = new Parrot(new Long(2), "name2", "favoriteFood2", new Double(2), SpeakType.CAN_SPEAK);
        Assert.assertFalse(parrotOne.equals(parrotTwo));
    }
    
}
