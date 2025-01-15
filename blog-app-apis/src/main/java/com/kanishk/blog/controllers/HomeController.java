package com.kanishk.blog.controllers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HomeController {
    @GetMapping("/")
	public String hello() {
	return"Hello World!";
	}
}

