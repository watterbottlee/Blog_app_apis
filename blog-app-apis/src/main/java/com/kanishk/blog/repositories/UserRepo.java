package com.kanishk.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kanishk.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer>{
	

}
