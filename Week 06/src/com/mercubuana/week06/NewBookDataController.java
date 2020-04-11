package com.mercubuana.week06;

public class NewBookDataController {


	public static void AddNewBookData(String BookTitle, String Author, char Category, int Stock) {
		/*
		 * 	e.) this section is related to the class in book class 
		 */
		
		Book newBook = new Book(BookTitle, Author, Category, Stock);
		
		/*
		 * WE WILL ALSO ADD THE NEW OBJECT TO THE CLASS THAT HOLD
		 * GLOBAL APPLICATION DATA
		 */
		ApplicationGlobalData.ListOfBooks.add(newBook);
		
	}
	public static String getListOfBook() {
		String view = "";
		/*
		 * 			- Use a loop to Build the view string using all the objects data
		 * 			  in the calss that hold the global data
		 */
			for (Book aBook:ApplicationGlobalData.ListOfBooks) {
					view += String.format("Book Title: %s \n"
								+"Author: %s \n"
								+"Category: %s \n"
								+"Stock: %d \n\n"
								, aBook.getBookTitle()
								, aBook.getAuthor()
								, aBook.getCategory()=='F'? "Fiction" : "Non-fiction"
								, aBook.getStock());
			}
		return view;
	}
}
