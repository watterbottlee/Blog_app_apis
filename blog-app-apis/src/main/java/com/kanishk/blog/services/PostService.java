package com.kanishk.blog.services;

import java.util.List;

import com.kanishk.blog.entities.Post;
import com.kanishk.blog.payloads.PostDto;

public interface PostService {
	
    //create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	//update
	PostDto  updatePost(PostDto postDto,Integer postId);
	//delete
	void deletePost(Integer postId);
	//get all posts
	List<PostDto> getAllPost();
	//get single post
	PostDto getPostById(Integer postId);
	//get post by category
	List<PostDto> getPostByCategory(Integer categoryId);
    //get post by user
	List<PostDto> getPostByUser(Integer userId);
	
	//search post
	List<Post> searchPost(String keyword);
}
