package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.model.Library;
import com.klu.service.LibraryService;

@RestController
@RequestMapping("/api")
public class LibraryController {

	@Autowired
	private LibraryService service;
	
	@GetMapping("/welcome")
	public String greet() {
		return service.greet();
	}
	
	@GetMapping("/library/getcount")
	public int CountBooks() {
		return service.countBooks();
	}
	
	@GetMapping("/library/getprice/{id}")
	public double getPrice(@PathVariable int id) {
		return service.bookPrice(id);
	}
	
	@GetMapping("/library/getbooktitles")
	public List<String> getBookTitles(){
		return service.getBookTitles();
	}
	
	@GetMapping("/library/getbookdetails/{id}")
	public Library getBookDetails(@PathVariable int id) {
	    return service.getBookDetails(id);
	}
	
	@GetMapping("/library/searchbook")
	public String searchBook(@RequestParam String title) {
		return service.searchBook(title);		
	}
	
	@GetMapping("/library/getauthor")
	public String getAuthor(@RequestParam String author) {
		return service.getAuthor(author);		
	}
	
	@PostMapping("/library/add")
	public Library addBook(@RequestBody Library library) {
		return service.addBook(library);
	}
	
	@GetMapping("/library/viewbooks")
	public List<Library> viewBooks(){
		return service.viewBooks();
	}
}
