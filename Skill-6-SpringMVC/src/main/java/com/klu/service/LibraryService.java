package com.klu.service;

import java.util.List;
import com.klu.model.Library;
public interface LibraryService {
   public String greet();
   public int countBooks();
   public double bookPrice(int id);
   public List<String> getBookTitles();
   public Library getBookDetails(int id);
   public String searchBook(String title);
   public String getAuthor(String Author);
   public Library addBook(Library library);
   public List<Library> viewBooks();
	
}

