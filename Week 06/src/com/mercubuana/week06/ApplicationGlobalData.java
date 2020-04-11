package com.mercubuana.week06;

import java.util.ArrayList;

public class ApplicationGlobalData {
	/*
	 * 1. Declare a static variable so it will be created
	 * 	  even when the object of this class is not created 
	 * The static variable is a list or a collection that can 
	 * hold multiple objects in it
	 */
	
	public static ArrayList<Book >ListOfBooks =new ArrayList<Book>();
	
	
	/*
	 * Declare a static variable, to save the list of patients
	 */
	public static ArrayList<Borrower> ListOfBorrower = new ArrayList<Borrower>();
}
