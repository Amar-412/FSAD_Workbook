package com.klu.model;

public class Library {
   private int id; 
   private String title;
   private String author;
   private double price;
   private int count;
   
   
   public Library() {
	   
   }
   public Library(int id ,String title , String author, double price, int count) {
	   this.id = id;
	   this.title = title;
	   this.author = author;
	   this.price = price;
	   this.count = count;
   }
   
   public int getId() {
	   return id;
   }
   public void setId(int id) {
	   this.id = id;
   }
   public String getTitle() {
	   return title;
   }
   public void setTitle(String title) {
	   this.title = title;
   }
   public String getAuthor() {
	   return author;
   }
   public void setAuthor(String author) {
	   this.author = author;
   }
   public double getPrice() {
	   return price;
   }
   public void setPrice(double price) {
	  this.price = price;
   }
   public int getCount() {
	   return count;
   }
   public void setCount(int count) {
	   this.count = count;
   }
}
