package com.klef.jfsd.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService servcie;
	

	@GetMapping("/")
	public String home()
	{
		return "Spring Boot Rest API";
	}
	
	@PostMapping("add")
	public String addBook(@RequestBody  Book B) 
	{
		return servcie.addbook(B);
	}
	

	
	   @PutMapping("update")
		public String  updateBook(@RequestBody Book B) 
	   {
		return servcie.updateBook(B);
		}

	   
	   
}
