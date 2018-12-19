package com.singular.cover.zoo.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.singular.cover.zoo.model.Animal;

/**
 * @author mauro-sanchez
 */
public class AnimalFileTest {
	
	public static final String ANIMALS_FILE_VALID_PATH = "./src/test/resources/animals.txt";
	public static final String ANIMALS_FILE_INVALID_PATH = "./src/test/resources/test.txt";
	public static final String ANIMALS_FILE_VALID_LINE = "./src/test/resources/animalValidLine.txt";
	public static final String ANIMALS_FILE_INVALID_LINE = "./src/test/resources/animalInvalidLine.txt";
	

	@Test
	public void given_aValidPath_when_tryReadFile_then_loadAnimal() {
		AnimalFileTxtDao animalFile = new AnimalFileTxtDao();
		List<Animal> animals = animalFile.load(ANIMALS_FILE_VALID_PATH);
		Assert.assertNotNull(animals);
	}
	
	@Test
	public void given_aInvalidPath_when_tryReadFile_then_animalIsNull() {
		AnimalFileTxtDao animalFile = new AnimalFileTxtDao();
		List<Animal> animals = animalFile.load(ANIMALS_FILE_INVALID_PATH);
		Assert.assertNull(animals);
	}
	
	@Test
	public void given_aFileWithOneValidLine_when_tryReadFile_then_animalSizeIsOne() {
		AnimalFileTxtDao animalFile = new AnimalFileTxtDao();
		List<Animal> animals = animalFile.load(ANIMALS_FILE_VALID_LINE);
		Assert.assertEquals(1, animals.size());
	}
	
	@Test
	public void given_aFileWithOneInvalidLine_when_tryReadFile_then_animalEmpty() {
		AnimalFileTxtDao animalFile = new AnimalFileTxtDao();
		List<Animal> animals = animalFile.load(ANIMALS_FILE_INVALID_LINE);
		Assert.assertTrue(animals.isEmpty());
	}

	@Test
	public void given_aExistFile_when_verifiedIfExist_then_returnTrue() {
		AnimalFileTxtDao animalFile = new AnimalFileTxtDao();
		Assert.assertTrue(animalFile.isExistAnimals(ANIMALS_FILE_VALID_LINE));
	}
	
	@Test
	public void given_aNotExistFile_when_verifiedIfExist_then_returnFalse() {
		AnimalFileTxtDao animalFile = new AnimalFileTxtDao();
		Assert.assertFalse(animalFile.isExistAnimals(ANIMALS_FILE_INVALID_PATH));
	}
}
