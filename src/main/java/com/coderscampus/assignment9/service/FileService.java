package com.coderscampus.assignment9.service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.assignment9.domain.Recipe;



@Service
public class FileService {
	//String targetFileLocation


	
	public FileService () {
		// this is just a blank no arg constructor because we also
		//  have a 1-arg constructor explicitly defined (below)
	}
		
	public List<Recipe> ingestData () throws IOException {
		String targetFileLocation;
		targetFileLocation= System.getProperty("user.dir");
		targetFileLocation=targetFileLocation+"/data/recipes.txt";
		Iterable<CSVRecord> records = null;
		List<Recipe> recipes = new ArrayList<>();
		CSVFormat csvFormat = CSVFormat.DEFAULT
				.withEscape('\\')
				.withHeader()
				.withIgnoreSurroundingSpaces();
		try (Reader in = new FileReader(targetFileLocation))
		{
			records = csvFormat.parse(in);
			Integer i = 0;
			for (CSVRecord record : records) {
				
				//System.out.println(record.get("Cooking Minutes")+","+record.get("Dairy Free")+","+record.get("Gluten Free")+","+record.get("Instructions")+","+
				//		record.get("Preparation Minutes")+","+record.get("Price Per Serving")+","+record.get("Ready In Minutes")+","+record.get("Servings")+","+
				//		record.get("Spoonacular Score")+","+record.get("Title")+","+record.get("Vegan")+","+record.get("Vegetarian"));
				Integer recipeNumber = i+1;
				Integer cookingMinutes = Integer.parseInt(record.get("Cooking Minutes"));
				Boolean dairyFree = Boolean.parseBoolean(record.get("Dairy Free"));
				Boolean glutenFree = Boolean.parseBoolean(record.get("Gluten Free"));
				String instructions = record.get("Instructions");
				Double prepMin = Double.parseDouble(record.get("Preparation Minutes"));
				Double price = Double.parseDouble(record.get("Price Per Serving"));
				Integer readyInMin = Integer.parseInt(record.get("Ready In Minutes"));
				Integer servings = Integer.parseInt(record.get("Servings"));
				Double score = Double.parseDouble(record.get("Spoonacular Score"));
				String title = record.get("Title");
				Boolean vegan = Boolean.parseBoolean(record.get("Vegan"));
				Boolean vegetarian = Boolean.parseBoolean(record.get("Vegetarian"));
				Recipe recipe = new Recipe(recipeNumber, cookingMinutes, dairyFree, glutenFree, instructions, prepMin, price, readyInMin, servings, score, title, vegan, vegetarian);
				recipes.add(recipe);
				//recipeData.getRecipes().add(recipe);
				i++;
			}
			}
		 catch (IOException e) {
			e.printStackTrace();
		}
		return recipes;
	}
}
