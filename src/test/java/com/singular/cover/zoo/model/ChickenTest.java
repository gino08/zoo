package com.singular.cover.zoo.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mauro-sanchez
 */
public class ChickenTest {
	
	@Test(expected = NullPointerException.class)
	public void given_aNullId_when_createChicken_then_nullPointerException() {
		new Chicken(null, "name", "favoriteFood", new Double(1), BroilerType.BROILER);
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullName_when_createChicken_then_nullPointerException() {
		new Chicken(new Long(1), null, "favoriteFood", new Double(1), BroilerType.BROILER);
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullFavoriteFood_when_createChicken_then_nullPointerException() {
		new Chicken(new Long(1), "name", null, new Double(1), BroilerType.BROILER);
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullLengthOfWings_when_createChicken_then_nullPointerException() {
		new Chicken(new Long(1), "name", "favoriteFood", null, BroilerType.BROILER);
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullBroiler_when_createChicken_then_nullPointerException() {
		new Chicken(new Long(1), "name", "favoriteFood", new Double(1), null);
	}
	
	@Test
	public void given_allData_when_createChicken_then_createSuccess() {
		Assert.assertNotNull(new Chicken(new Long(1), "name", "favoriteFood", new Double(1), BroilerType.BROILER));
	}
	
	@Test
	public void given_aTwoChickensWithSameId_when_useEquals_then_returnTrue() {
		Chicken chickenOne = new Chicken(new Long(1), "name1", "favoriteFood1", new Double(1), BroilerType.BROILER);
		Chicken chickenTwo = new Chicken(new Long(1), "name2", "favoriteFood2", new Double(2), BroilerType.BROILER);
        Assert.assertTrue(chickenOne.equals(chickenTwo));
    }

    @Test
    public void given_aTwoChickensWithDifferentId_when_useEquals_then_returnFalse() {
    	Chicken chickenOne = new Chicken(new Long(1), "name1", "favoriteFood1", new Double(1), BroilerType.BROILER);
		Chicken chickenTwo = new Chicken(new Long(2), "name2", "favoriteFood2", new Double(2), BroilerType.BROILER);
        Assert.assertFalse(chickenOne.equals(chickenTwo));
    }
    
}
