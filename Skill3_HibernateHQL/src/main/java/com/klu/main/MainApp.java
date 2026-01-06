package com.klu.main;


import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.klu.model.Product;
import com.klu.util.*;
//import com.mysql.cj.Query;

import org.hibernate.query.Query;   // ✅ generic

public class MainApp {

	static SessionFactory factory = HibernateUtil.getSessionFactory();
	public static void main(String [] args) throws Exception{
	Scanner sc = new Scanner(System.in);	
	int choice;
	do {
		System.out.println("\n======Product Menu======\n");
		System.out.println("1. Insert Product");
		System.out.println("2. View Product details");
		System.out.println("3. Update Product details");
		System.out.println("4. Delete Product");
		System.out.println("5. View Product in Ascending Order By Price");
		System.out.println("6. View Product in Descending Order By Price");
		System.out.println("7. View Product in Descending Order By Quantity");
		System.out.println("8. Get the First Three Products");
		System.out.println("9. Get the next three Products");
		System.out.println("10. Perform aggregate functions");
		System.out.println("11. Group the products by description");
		System.out.println("12. Get the products within a price range");
		System.out.println("13. Get the product that starts with some pattern");
		System.out.println("14. exit");
		System.out.println("Enter Choice: ");
		
		choice = sc.nextInt();
		
		switch(choice) {
		case 1: insertProduct(); break;
		case 2: viewProduct();break;
		case 3: updateProduct();break;
		case 4: deleteProduct();break;
		case 5: viewProductAsc();break;
		case 6: viewProductDesc();break;
		case 7: viewProductByQuantity();break;
		case 8: getFirstThreeProducts();break;
		case 9: getNextThreeProducts();break;
		case 10: aggregateFunctions();break;
		case 11: groupProductsByDesc();break;
		case 12: getProductsWithinPriceRange();break;
		case 13: productSearchByPattern();break;
		
		}
		
	}while(choice!=14);
  }



private static void insertProduct() {
	Scanner sc = new Scanner(System.in);
	Session  session = factory.openSession();
	Transaction tx = session.beginTransaction();
	
	Product prod = new Product();
	System.out.print("Enter the Name of the product: ");
	String name=sc.nextLine();
	prod.setName(name);
	
	System.out.print("Enter the Description of the product: ");
	String des=sc.nextLine();
	prod.setDescription(des);
	
	System.out.print("Enter the Price of the product: ");
	double price=sc.nextDouble();
	prod.setPrice(price);
	
	System.out.print("Enter the Quantity of the product: ");
	int quant=sc.nextInt();
	prod.setQuantity(quant);
	
	session.persist(prod);
	tx.commit();
	session.close();
	
	System.out.println("A record has been successfully inserted into the product table");
}


private static void viewProduct() {
	Scanner sc = new Scanner(System.in);
	Session session = factory.openSession();
	
	
	System.out.print("Enter the ID of the product to be viewed: ");
	int id = sc.nextInt();
	
	Product prod = session.get(Product.class ,id);
	
	if(prod!=null) {
		System.out.println("Name: "+prod.getName());
		System.out.println("Description: "+prod.getDescription());
		System.out.println("Price: "+prod.getPrice());
		System.out.println("Quantity: "+prod.getQuantity());
	}else {
		System.out.println("Product not found!");
	}
	session.close();
}

private static void updateProduct() {
	Scanner sc = new Scanner(System.in);
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	
	System.out.println("Enter the Product ID");
	int id = sc.nextInt();
	Product prod =session.get(Product.class, id);	
	if(prod!=null) {
		System.out.println("Enter the product price");
		prod.setPrice(sc.nextDouble());
		tx.commit();
		System.out.println("The Price is Updated");
	}else {
		System.out.println("Product not found!");
	}
	session.close();
}

private static void deleteProduct() {
	Scanner sc = new Scanner(System.in);
	Session session = factory.openSession();
	Transaction tx = session.beginTransaction();
	
	System.out.print("Enter the ID of the product to be deleted: ");
	int id = sc.nextInt();
	
	Product prod =session.get(Product.class, id);	
	if(prod!=null) {
		session.remove(prod);
		tx.commit();
		System.out.println("Product is deleted");
	}else {
		System.out.println("Product is not found");
		tx.rollback();
	}
	session.close();
}

private static void viewProductAsc() {
	Session session = factory.openSession();
	Query<Product> q = session.createQuery("from Product order by price", Product.class);
	System.out.println("\nName | Description | Price | Quantity");
	for (Product e : q.list()) {
	System.out.println(e.getName() + " | " + e.getDescription() + " | " +
	e.getPrice() + " | " + e.getQuantity());
	}
	session.close();
}

private static void viewProductDesc() {
	Session session = factory.openSession();
	Query<Product> q = session.createQuery("from Product order by price desc", Product.class);
	System.out.println("\nName | Description | Price | Quantity");
	for (Product e : q.list()) {
	System.out.println(e.getName() + " | " + e.getDescription() + " | " +
	e.getPrice() + " | " + e.getQuantity());
	}
	session.close();
}

private static void viewProductByQuantity() {
	Session session = factory.openSession();
	Query<Product> q = session.createQuery("from Product order by quantity desc", Product.class);
	System.out.println("\nName | Description | Price | Quantity");
	for (Product e : q.list()) {
	System.out.println(e.getName() + " | " + e.getDescription() + " | " +
	e.getPrice() + " | " + e.getQuantity());
	}
	session.close();
}

private static void getFirstThreeProducts() {
	Session session = factory.openSession();
	Query<Product> q = session.createQuery("from Product", Product.class);
	q.setFirstResult(0);
	q.setMaxResults(3);
	System.out.println("\nName | Description | Price | Quantity");
	for (Product e : q.list()) {
	System.out.println(e.getName() + " | " + e.getDescription() + " | " +
	e.getPrice() + " | " + e.getQuantity());
	}
	session.close();
}


private static void getNextThreeProducts() {
	Session session = factory.openSession();
	Query<Product> q = session.createQuery("from Product", Product.class);
	q.setFirstResult(3);
	q.setMaxResults(3);
	System.out.println("\nName | Description | Price | Quantity");
	for (Product e : q.list()) {
	System.out.println(e.getName() + " | " + e.getDescription() + " | " +
	e.getPrice() + " | " + e.getQuantity());
	}
	session.close();
}

private static void aggregateFunctions() {
	Session session = factory.openSession();
	 Query q1 = session.createQuery("select count(*) from Product");
	 long totalProducts = (Long) q1.uniqueResult();
	 
	 Query q2= session.createQuery("select count(*) from Product where quantity>0");
	    long totalProducts1 = (Long) q2.uniqueResult();

	    Query q3 = session.createQuery("select count(*) from Product group by description");
	    long totalProducts2 = (Long) q3.uniqueResult();

	    Query q4 = session.createQuery("select max(price) from Product");
	    double maxPrice = (Double) q4.uniqueResult();

	    Query q5 = session.createQuery("select min(price) from Product");
	    Double minPrice = (Double) q5.uniqueResult();
	
	     System.out.println("\nTotal Number of Products: "+totalProducts);
	     System.out.println("Total Number of Products whose quantity is greater than zero: "+totalProducts1);
	     System.out.println("Total Number of Products grouped by description: "+totalProducts2);
	     System.out.println("Minimum Price: "+minPrice);
	     System.out.println("Maximum Price: "+maxPrice);
	     
	     
	
}

private static void groupProductsByDesc() {
  Session session = factory.openSession();
  Query<Product> q = session.createQuery("from Product group by description", Product.class);
  System.out.println("\nName | Description | Price | Quantity");
	for (Product e : q.list()) {
	System.out.println(e.getName() + " | " + e.getDescription() + " | " +
	e.getPrice() + " | " + e.getQuantity());
	}
	session.close();
  
}

private static void getProductsWithinPriceRange() {
	Scanner sc = new Scanner(System.in);
	  Session session = factory.openSession();
	  System.out.print("\nEnter the minimum price: ");
	  double mini=sc.nextDouble();
	  System.out.print("\nEnter the maximum price: ");
	  double maxi=sc.nextDouble();
	  Query<Product> q = session.createQuery("from Product where price between :min and :max", Product.class);
	  q.setParameter("min",mini);
	  q.setParameter("max",maxi);
	  System.out.println("\nName | Description | Price | Quantity");
		for (Product e : q.list()) {
		System.out.println(e.getName() + " | " + e.getDescription() + " | " +
		e.getPrice() + " | " + e.getQuantity());
		}
		session.close();
	  
	}
private static void productSearchByPattern() {
	Scanner sc = new Scanner(System.in);
	  Session session = factory.openSession();
	  System.out.print("\nEnter the product name pattern: ");
	  String s = sc.nextLine();
	  
	  
	  Query<Product> q = session.createQuery("FROM Product WHERE name LIKE :name", Product.class);
	  q.setParameter("name", s + "%");
	  System.out.println("\nName | Description | Price | Quantity");
		for (Product e : q.list()) {
		System.out.println(e.getName() + " | " + e.getDescription() + " | " +
		e.getPrice() + " | " + e.getQuantity());
		}
		session.close();
	  
	}
    
}





