package com.kanishk.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanishk.blog.entities.Category;
import com.kanishk.blog.entities.Post;
import com.kanishk.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);

}
