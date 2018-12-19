package com.singular.cover.zoo.services;

import java.io.File;
import java.util.List;

import com.singular.cover.zoo.ZooConstants;
import com.singular.cover.zoo.dao.AnimalFileDao;
import com.singular.cover.zoo.dao.AnimalFileTxtDao;
import com.singular.cover.zoo.model.Animal;

/**
 * Implementation of the interface AnimalService.
 * Use AnimalFileDao for load animals.
 *
 * @author mauro-sanchez
 */
public class AnimalServiceFiles implements AnimalService {
	
	private AnimalFileDao dao;
	
	public AnimalServiceFiles() {
		dao = new AnimalFileTxtDao();
	}
	
	@Override
	public List<Animal> loadAllAnimals() {
		return dao.load(ZooConstants.FOLDER_RESOURCES_PATH + ZooConstants.ANIMAL_FILE_PATH);
	}

	@Override
	public void setUpAnimals() {
		createFolderIfNotExist(ZooConstants.FOLDER_RESOURCES_PATH);
		if (!dao.isExistAnimals(ZooConstants.FOLDER_RESOURCES_PATH + ZooConstants.ANIMAL_FILE_PATH))
			dao.createInitialAnimals(ZooConstants.ANIMAL_FILE_PATH, ZooConstants.FOLDER_RESOURCES_PATH + ZooConstants.ANIMAL_FILE_PATH);
	}
	
	private void createFolderIfNotExist(String path) {
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdirs();
		}
	}
}
