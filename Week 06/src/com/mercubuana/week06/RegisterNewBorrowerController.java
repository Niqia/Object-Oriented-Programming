package com.mercubuana.week06;

import java.util.Date;

public class RegisterNewBorrowerController {
	
	//we need to declare static variable to record the selected book
	private static Book savedSelectedBook;
	//and we also need a GET Method
	public static Book getSelectedBook() {
		return savedSelectedBook;
	}
	// A static method to save new patient data
	public static void saveBorrowertData(String BorrowerName, Date BorrowDate) {
		/*
		 * Create New Borrower Object
		 * 
		 * we get the category of the selected book from the selected category of the books that are available
		 * and we get the selected book from the selected book data in the static variable
		 */
		Borrower newBorrower = new Borrower(BorrowerName, savedSelectedBook.getCategory(),
				BorrowDate, savedSelectedBook);
		//Add the new borrower object to application global data
		ApplicationGlobalData.ListOfBorrower.add(newBorrower);
	}
	
	//Another static method to get the list of borrower in the application global data
	public static String getListOfBorrowers() {
		String listOfBorrowers = "";
		for (Borrower p:ApplicationGlobalData.ListOfBorrower) {
			listOfBorrowers += String.format("Name: %s\n"
					+ "Book Category: %s\n0"
					+ "Borrowed Book: %s\n"
					+ "Borrow Date: %s\n", 
					p.getBorrowerName(),
					p.getCategory()=='F'?"Fiction":"Non-fiction",
					p.getBorrowerBook().getBookTitle(),
					p.getBorrowDate().toString()
					);
		}
		return listOfBorrowers;
	}
	
	public static void saveBorrowerData(String BorrowerName, Date BorrowDate) {
		Borrower newBorrower = new Borrower(BorrowerName, savedSelectedBook.getCategory(), BorrowDate, savedSelectedBook);
		ApplicationGlobalData.ListOfBorrower.add(newBorrower);
		savedSelectedBook.setEmptyStock(savedSelectedBook.getEmptyStock()-1);
	}
	
	public static String searchAvailableBooks(char Category) {
		String selectedBook = "";
		
		/*
		 * ALGORITHM TO FIND THE SUITABLE Book FOR THE BORROWER
		 * 
		 * 1. Loop into each Book object in the global data to check for the suitable  Book.
		 * a. The category that the borrower selected must be the same with the category of the 
		 * 	  available books
		 * b. It must have at least one Stock (emptyStock > 0)
		 * c. If condition A and condition B are fulfilled for more than one 
		 * 	  Book, then select the book with more stock available.
		 */
		int mostEmptyBed = 0;
		for (Book b:ApplicationGlobalData.ListOfBooks) {
			//1a. Check for condition (A), (B) and (C)
			if (b.getCategory()==Category && b.getEmptyStock()>0 && mostEmptyBed < b.getEmptyStock()) {
				//Set the selected book to this book object
				selectedBook = b.getBookTitle();
				//Set the mostEmptyStock to this objects's empty stock
				mostEmptyBed = b.getEmptyStock();
				//save the selected biik in a static variable 
				savedSelectedBook = b;
			}
		}
		return selectedBook;
	}

}
