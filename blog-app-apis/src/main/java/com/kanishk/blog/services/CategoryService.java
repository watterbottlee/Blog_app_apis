package com.kanishk.blog.services;

import java.util.List;

import com.kanishk.blog.payloads.CategoryDto;

public interface CategoryService {
	
	//create 
	CategoryDto createCategory(CategoryDto categorydto);
	
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	//delete
	void deleteCategory(Integer categoryId);
	
	//get
	CategoryDto getCategory(Integer categoryId);
	
	//getAll
	List<CategoryDto> getAllCategories();

}
