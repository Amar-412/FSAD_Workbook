package com.klu.serviceimpl;

import java.util.*;

import org.springframework.stereotype.Service;

import com.klu.model.Library;
import com.klu.service.*;
@Service
public class ServiceImpl implements LibraryService {

	List<Library> bookList= new ArrayList<>();
	
	@Override
	public String greet() {
		return "Hi there, Welcome to Hogwards";
		
	}

	@Override
	public int countBooks() {
		return bookList.size();
	}

	@Override
	public double bookPrice(int id) {
		for(Library l : bookList) {
			if(l.getId() == id) {
				return l.getPrice();
			}
		}
		return 0;
	}

	@Override
	public List<String> getBookTitles() {
		List<String> titles = new ArrayList<>();
		for(Library l : bookList) {
			titles.add(l.getTitle());
		}
		return titles;
	}

	@Override
	public Library getBookDetails(int id) {
		for(Library l :bookList) {
			if(l.getId() == id) {
				return l;
			}
		}
		return null;
	}

	@Override
	public String searchBook(String title) {
		for(Library l :bookList) {
			if(l.getTitle().equalsIgnoreCase(title)) {
				return "Book with the title "+title+" is found";
			}
		}
		
		return "Book not found";
	}

	@Override
	public String getAuthor(String Author) {
		for(Library l :bookList) {
			if(l.getAuthor().equalsIgnoreCase(Author)) {
				return "Book Details:- Id:"+l.getId()+" Author: "+Author+ " Title: "+l.getTitle()+" Price: "+l.getPrice()+" Count: "+l.getCount();
			}
		}
		return "Author not found";
	}

	@Override
	public Library addBook(Library library) {
		bookList.add(library);
		return library;
	}

	@Override
	public List<Library> viewBooks() {
		return bookList;
	}
}
