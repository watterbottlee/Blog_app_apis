package com.kanishk.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanishk.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
	
}
