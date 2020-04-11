package com.mercubuana.week06;
import java.util.ArrayList;

public class Book {
	//1. Fields/attributes of class
	private String BookTitle = "";
	private String Author = "";
	private char Category = 'F';
	private int Stock = 0;
	private int emptyStock = 0;
	
	
	
	
	//2. Constructor
	public Book(String BookTitle, String Author, char Category, int Stock) {
		super();
		this.BookTitle = BookTitle;
		this.Author = Author;
		this.Category = Category;
		this.Stock = Stock;
		this.emptyStock = Stock;
	}

	//3. Getters and Setters methods
	public String getBookTitle() {
		return BookTitle;
	}


	public void setBookTitle(String bookTitle) {
		BookTitle = bookTitle;
	}


	public String getAuthor() {
		return Author;
	}


	public void setAuthor(String author) {
		Author = author;
	}


	public char getCategory() {
		return Category;
	}


	public void setCategory(char category) {
		Category = category;
	}


	public int getStock() {
		return Stock;
	}


	public void setStock(int stock) {
		Stock = stock;
	}


	public int getEmptyStock() {
		return emptyStock;
	}


	public void setEmptyStock(int emptyStock) {
		this.emptyStock = emptyStock;
	}
	
	
	
	
	

}
