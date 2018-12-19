package com.singular.cover.zoo.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author mauro-sanchez
 */
public class FriendTest {
	
	@Test(expected = NullPointerException.class)
	public void given_aNullAnimal_when_createFriend_then_nullPointerException() {
		new Friend(null, new Integer(1));
	}
	
	@Test(expected = NullPointerException.class)
	public void given_aNullDay_when_createFriend_then_nullPointerException() {
		new Friend(new Dog(new Long(1), "name", "favoriteFood", "dogType"), null);
	}
	
	@Test
	public void given_allData_when_createFriend_then_createSuccess() {
		Assert.assertNotNull(new Friend(new Dog(new Long(1), "name", "favoriteFood", "dogType"), new Integer(1)));
	}
	
	@Test
	public void given_aTwoFriendsWithSameAnimal_when_useEquals_then_returnTrue() {
		Friend friendOne = new Friend(new Dog(new Long(1), "name1", "favoriteFood1", "dogType1"), new Integer(1));
		Friend friendTwo = new Friend(new Dog(new Long(1), "name2", "favoriteFood2", "dogType2"), new Integer(2));
        Assert.assertTrue(friendOne.equals(friendTwo));
    }

    @Test
    public void given_aTwoFriendsWithDifferentAnimal_when_useEquals_then_returnFalse() {
    	Friend friendOne = new Friend(new Dog(new Long(1), "name1", "favoriteFood1", "dogType1"), new Integer(1));
    	Friend friendTwo = new Friend(new Dog(new Long(2), "name2", "favoriteFood2", "dogType2"), new Integer(2));
        Assert.assertFalse(friendOne.equals(friendTwo));
    }
    
}
