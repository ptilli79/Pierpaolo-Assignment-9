package com.coderscampus.assignment9.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.FileService;

//import ch.qos.logback.classic.Logger;



@RestController
public class FileController {
	
	//@Autowired
	//final static Logger logger = Logger.getLogger(FileController.class);
	//private static Logger logger = Logger.getLogger(FileController.class);

	@Autowired
	private FileService fileService;
	
	
	//private List<Recipe> ingestedRecipes;
	
	@GetMapping("/gluten-free")
		List<Recipe> ingestGlutenFreeRecipes() throws IOException{
	// List<String> ingestGlutenFreeRecipes() throws IOException{
		String targetFile= System.getProperty("user.dir");
		targetFile=targetFile+"/data/recipes.txt";
		
		//List<Recipe> recipes;
		//List<String> recipesToString = new ArrayList<>();
		
		//recipes=fileService.ingestData()
		//		  .stream()
		//		  .filter(Recipe::getGlutenFree)
		//		  .collect(Collectors.toList());
		
		//recipesToString.add("Total count of recipes --> " +String.valueOf(recipes.stream().count()));
		
		//for (int i=0; i<recipes.size(); i++) {
		//recipesToString.add(recipes.get(i).toString());
		//}
		// return recipesToString;	
		return(fileService.ingestData()
				  .stream()
				  .filter(Recipe::getGlutenFree)
				  .collect(Collectors.toList()));
	}

	@GetMapping("/vegan")
	public List<Recipe> ingestVeganRecipes() throws IOException{
	//public List<String> ingestVeganRecipes() throws IOException{
		String targetFile= System.getProperty("user.dir");
		targetFile=targetFile+"/data/recipes.txt";
		return(fileService.ingestData()
				  .stream()
				  .filter(Recipe::getVegan)
				  .collect(Collectors.toList()));
	}

	@GetMapping("/vegan-and-gluten-free")
	public List<Recipe> ingestVeganGluenFreeRecipes() throws IOException{
		String targetFile= System.getProperty("user.dir");
		targetFile=targetFile+"/data/recipes.txt";

		return (fileService.ingestData()
				  .stream()
				  .filter(Recipe::getVegan).filter(Recipe::getGlutenFree)
				  .collect(Collectors.toList()));	
	}

	@GetMapping("/vegetarian")
	public List<Recipe> ingestVegetarianRecipes() throws IOException{
		String targetFile= System.getProperty("user.dir");
		targetFile=targetFile+"/data/recipes.txt";
		
		return (fileService.ingestData()
				  .stream()
				  .filter(Recipe::getVegetarian)
				  .collect(Collectors.toList()));	
	}

	
	@GetMapping("/all-recipes")
	public List<Recipe> ingestAllRecipes() throws IOException{
		String targetFile= System.getProperty("user.dir");
		targetFile=targetFile+"/data/recipes.txt";
		
		return (fileService.ingestData()
				  .stream()
				  .collect(Collectors.toList()));
	}
	}

	
	
	
	
	

