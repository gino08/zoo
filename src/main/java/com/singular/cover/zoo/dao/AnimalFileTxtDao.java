package com.singular.cover.zoo.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.lang3.math.NumberUtils;

import com.singular.cover.zoo.ZooConstants;
import com.singular.cover.zoo.dao.typeHandler.AnimalTypeHandler;
import com.singular.cover.zoo.dao.typeHandler.BroilerTypeHandler;
import com.singular.cover.zoo.dao.typeHandler.SpeakTypeHandler;
import com.singular.cover.zoo.model.Animal;
import com.singular.cover.zoo.model.AnimalType;
import com.singular.cover.zoo.model.BroilerType;
import com.singular.cover.zoo.model.Chicken;
import com.singular.cover.zoo.model.Dog;
import com.singular.cover.zoo.model.Parrot;
import com.singular.cover.zoo.model.SpeakType;

/**
 * Implementation of the interface AnimalFileDao.
 * Manage animals in TXT files.
 *
 * @author mauro-sanchez
 */
public class AnimalFileTxtDao implements AnimalFileDao {
	
	private List<Animal> animals;
	
	@Override
	public List<Animal> load(String path) {
		animals = null;
		try (Stream<String> stream = Files.lines(Paths.get(path))) {
			animals = new ArrayList<Animal>();
			stream.forEach(line -> {
				if (validLine(line)) {
					String[] cardLine = line.split(ZooConstants.ANIMAL_SPLITTER);
					switch (getAnimalType(cardLine)) {
					case DOG:
						animals.add(new Dog(getId(cardLine), getName(cardLine), getFavoriteFood(cardLine), getDogType(cardLine)));
						break;
					case PARROT:
						animals.add(new Parrot(getId(cardLine), getName(cardLine), getFavoriteFood(cardLine), getLengthOfWings(cardLine), getSpeak(cardLine)));
						break;
					case CHICKEN:
						animals.add(new Chicken(getId(cardLine), getName(cardLine), getFavoriteFood(cardLine), getLengthOfWings(cardLine), getBroiler(cardLine)));
						break;
					default:
						throw new IllegalArgumentException("illegal value for AnimalType");
					}
				}
			});
		} catch (IOException e) {
			System.out.println("File not found.");
		}
		return animals;
	}
	
	@Override
	public boolean isExistAnimals(String path) {
		File animals = new File(path);
		return animals.exists();
	}
	
	@Override
	public void createInitialAnimals(String pathFrom, String pathTo) {
		File animals = new File(pathTo);
		if (!animals.exists()) {
			try
			{
				animals.createNewFile();
				InputStream inputStreamAnimals = getClass().getResourceAsStream(pathFrom);
				BufferedInputStream bufferedInput = new BufferedInputStream(inputStreamAnimals);
				FileOutputStream fileOutputAnimals = new FileOutputStream (animals);
				BufferedOutputStream bufferedOutput = new BufferedOutputStream(fileOutputAnimals);
				byte [] array = new byte[1000];
				int leidos = bufferedInput.read(array);
				while (leidos > 0)
				{
					bufferedOutput.write(array,0,leidos);
					leidos=bufferedInput.read(array);
				}
	
				bufferedOutput.close();
				bufferedInput.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private boolean validLine(String line) {
        String[] lines = line.trim().split(ZooConstants.ANIMAL_SPLITTER);
        return lines.length == 8 && !lines[0].isEmpty() && !lines[1].isEmpty() && !lines[2].isEmpty() && !lines[7].isEmpty();
    }
	
	private Long getId(String[] line) {
		return new Long(line[0]);
	}

	private String getName(String[] line) {
		return line[1];
	}
	
	private String getFavoriteFood(String[] line) {
		return line[2];
	}
	
	private String getDogType(String[] line) {
		return line[3];
	}
	
	private Double getLengthOfWings(String[] line) {
		return NumberUtils.createDouble(line[4]);
	}
	
	private SpeakType getSpeak(String[] line) {
		return SpeakTypeHandler.valueOf(line[5]);
	}
	
	private BroilerType getBroiler(String[] line) {
		return BroilerTypeHandler.valueOf(line[6]);
	}
	
	private AnimalType getAnimalType(String[] line) {
		return AnimalTypeHandler.valueOf(line[7]);
	}
}
