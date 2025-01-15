package com.kanishk.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanishk.blog.entities.Post;
import com.kanishk.blog.entities.User;
import com.kanishk.blog.exceptions.ResourceNotFoundException;
import com.kanishk.blog.payloads.PostDto;
import com.kanishk.blog.repositories.CategoryRepo;
import com.kanishk.blog.repositories.PostRepo;
import com.kanishk.blog.repositories.UserRepo;
import com.kanishk.blog.services.PostService;
import java.util.Date;
import com.kanishk.blog.entities.Category;

@Service
public class PostServiceImpl implements PostService {
 
	@Autowired
	private PostRepo postRepo;
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private UserRepo userRepo;	
	@Autowired
	private ModelMapper modelMapper;
	@Override
	
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		Category category =this.categoryRepo.findById(categoryId).
				orElseThrow(()->new ResourceNotFoundException("category","id",categoryId));

		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newPost = this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId).
			       orElseThrow(()->new ResourceNotFoundException("User","id",postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatedPost = this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId).
			       orElseThrow(()->new ResourceNotFoundException("User","id",postId));
		this.postRepo.delete(post);
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> allPosts =this.postRepo.findAll();
		List<PostDto> postDtos = allPosts.stream().map((post)->this.modelMapper.map(post, PostDto.class))
				.collect(Collectors.toList());
	    return postDtos;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId).
		       orElseThrow(()->new ResourceNotFoundException("User","id",postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category cat =this.categoryRepo.findById(categoryId).
				orElseThrow(()->new ResourceNotFoundException("category","category id",categoryId));
        List<Post> posts =this.postRepo.findByCategory(cat);
		List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	    return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user =this.userRepo.findById(userId).
				orElseThrow(()->new ResourceNotFoundException("user","user_id",userId));
        List<Post> posts =this.postRepo.findByUser(user);
		List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	    return postDtos;
	}

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}



}
