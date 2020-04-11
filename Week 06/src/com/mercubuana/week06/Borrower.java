package com.mercubuana.week06;

import java.util.Date;

public class Borrower {
	private String BorrowerName;
	private char Category = 'M';
	private Date BorrowDate; // To use "Date" data type , we have to include "import java.util.Date"
	private Book BorrowerBook;
	
	//constructor
	public Borrower(String BorrowerName, char Category, Date BorrowDate, Book BorrowerBook) {
		super();
		this.BorrowerName = BorrowerName;
		this.Category = Category;
		this.BorrowDate = BorrowDate;
		this.BorrowerBook = BorrowerBook;
	}
	
	
	//getter setter
	public String getBorrowerName() {
		return BorrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		BorrowerName = borrowerName;
	}

	public char getCategory() {
		return Category;
	}

	public void setCategory(char category) {
		Category = category;
	}

	public Date getBorrowDate() {
		return BorrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		BorrowDate = borrowDate;
	}

	public Book getBorrowerBook() {
		return BorrowerBook;
	}

	public void setBorrowerBook(Book borrowerBook) {
		BorrowerBook = borrowerBook;
	}
	
	
	
	
}
