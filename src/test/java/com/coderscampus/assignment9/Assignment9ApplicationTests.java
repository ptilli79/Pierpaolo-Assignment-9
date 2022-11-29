package com.coderscampus.assignment9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.coderscampus.assignment9.domain.Recipe;
import com.coderscampus.assignment9.service.FileService;

@SpringBootTest
class Assignment9ApplicationTests {
	
	List<Recipe> recipes = new ArrayList<>();
	FileService recipeData = new FileService();
	
	@Test
	public void should_return_100_recipes() {
		
		try {
			recipes=recipeData.ingestData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(recipes);
		assertEquals(100,recipes.size());
		}	
	
	@Test
	public void should_return_13_recipes() {
		
		try {
			recipes=recipeData.ingestData()
			  .stream()
			  .filter(Recipe::getVegan).filter(Recipe::getGlutenFree)
			  .collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(recipes);
		assertEquals(13,recipes.size());
		}	
	
	@Test
	public void should_return_55_recipes() {
		
		try {
			recipes=recipeData.ingestData()
			  .stream()
			  .filter(Recipe::getGlutenFree)
			  .collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(recipes);
		assertEquals(55,recipes.size());
		}
	
	@Test
	public void should_return_49_recipes() {
		
		try {
			recipes=recipeData.ingestData()
			  .stream()
			  .filter(Recipe::getVegetarian)
			  .collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(recipes);
		assertEquals(49,recipes.size());
		}
	
	@Test
	public void should_return_14_recipes() {
		
		try {
			recipes=recipeData.ingestData()
			  .stream()
			  .filter(Recipe::getVegan)
			  .collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(recipes);
		assertEquals(14,recipes.size());
		}
	
	
	
	
	}


