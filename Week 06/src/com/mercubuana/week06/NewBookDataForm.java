package com.mercubuana.week06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NewBookDataForm {

	private JFrame frmAddNewBook;
	private JTextField txtBookTitle;
	private JTextField txtAuthor;
	private JTextField txtStock;
	private JComboBox cmbCategory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewBookDataForm window = new NewBookDataForm();
					window.frmAddNewBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewBookDataForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddNewBook = new JFrame();
		frmAddNewBook.addWindowListener(new WindowAdapter() {
			
			public void windowClosed(WindowEvent arg0) {
			
				/*
				 * (non-Javadoc)
				 * @see java.awt.event.WindowAdapter#windowClosed(java.awt.event.WindowEvent)
				 * 
				 * If the add new book data form is closed, 
				 * this event will be triggered. In this event
				 * we will do 2 steps.
				 */
				
				//Step 1: Open the main menu form
				MainMenuForm.main(null);
				//Step 2: Dispose this (add new book) form
				frmAddNewBook.dispose();
			}
		});
		frmAddNewBook.setTitle("Add new Book Form");
		frmAddNewBook.setBounds(100, 100, 363, 300);
		frmAddNewBook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAddNewBook.getContentPane().setLayout(null);
		
		JLabel lblBookTitle = new JLabel("Book Title:");
		lblBookTitle.setBounds(24, 13, 79, 16);
		frmAddNewBook.getContentPane().add(lblBookTitle);
		
		txtBookTitle = new JTextField();
		txtBookTitle.setBounds(136, 11, 114, 20);
		frmAddNewBook.getContentPane().add(txtBookTitle);
		txtBookTitle.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(24, 59, 55, 16);
		frmAddNewBook.getContentPane().add(lblAuthor);
		
		txtAuthor = new JTextField();
		txtAuthor.setBounds(136, 57, 114, 20);
		frmAddNewBook.getContentPane().add(txtAuthor);
		txtAuthor.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(24, 113, 67, 16);
		frmAddNewBook.getContentPane().add(lblCategory);
		
		cmbCategory = new JComboBox();
		cmbCategory.setModel(new DefaultComboBoxModel(new String[] {"Fiction", "Non-fiction"}));
		cmbCategory.setBounds(136, 109, 114, 25);
		frmAddNewBook.getContentPane().add(cmbCategory);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(24, 168, 55, 16);
		frmAddNewBook.getContentPane().add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setBounds(136, 166, 114, 20);
		frmAddNewBook.getContentPane().add(txtStock);
		txtStock.setColumns(10);
		
		JButton btnSaveNewBook = new JButton("Save New Book Data");
		btnSaveNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Display the newly entered data of ward
				 * and create a new object from the ward class
				 * to store newly entered ward data
				 * 
				 * 1. Create new object from the ward class,
				 * but first we need to create the Ward class in Eclipse 
				 * 
				 * 	a.) Get the string data from text field "txtBookTitle" and "txtAuthor"
				 */
				
				String BookTitle = txtBookTitle.getText();
				String Author = txtAuthor.getText();
				
				/*	
				 * b.) Get the selected category  from the combo box
				 * 		- Declare char data type for category and set
				 * 		  default value for category
				 */
				
				char Category = 'F';
				
				/*
				 * 	c.) Check the selected index of the combo box
				 */
				
				if (cmbCategory.getSelectedIndex()==1) {
					/* If the salected index == 1, it means that the 2nd
					 * index is selected, the "Non-fiction one, 
					 * so change the Category variable value to  'N'.
					 * (combo index starts from 0 not 1)
					 */
					Category = 'N';
				}
				
				/*
				 * 	d.) Get the numeric data from "txtStock"
				 * 		- Get the string with temporary variable
				 */
				String temp = txtStock.getText();	
				
				/*
				 * 		- Convert The String to numeric data
				 */
				int Stock = 0;
				try {
					Stock = Integer.parseInt(temp);
				} catch (NumberFormatException e1) {
					/*
					 * If there is an error in the process of converting user
					 * display the message with a dialogue box and return or
					 * get out of this method
					 */
					JOptionPane.showMessageDialog(null, "You must enter numeric data in the \"STOCK\" field. \n please try again.");
					return;
				}
				
				/*
				 * e. Create a new Book object by calling a static method on the controller class.
				 * Calling a static method can be done without even creating a 
				 * controller object of the controller class
				 */
				NewBookDataController.AddNewBookData(BookTitle, Author, Category, Stock);
				
				/*
				 * 	f.) Display the new object data 
				 * 		- Declare a view string
				 */
				String view = "List of books: \n\n";
				
			/*
			 * Get the list of book by calling a static method in the controller
			 * class
			 */
				
				view += NewBookDataController.getListOfBook();
			
			/*
			 * 			- Display the view string using dialog box
			 */
			
			JOptionPane.showMessageDialog(null, view);
				
			}
		});
		btnSaveNewBook.setBounds(121, 202, 157, 26);
		frmAddNewBook.getContentPane().add(btnSaveNewBook);
	}

}
