package com.mercubuana.week06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JPanel;
import java.util.Date;

public class RegisterNewBorrowerForm {

	private JFrame frmRegisterNewBorrower;
	private JTextField txtSelectedBook;
	private JTextField txtNameOfBorrower;
	private JTextField txtBorrowDate;
	private JPanel panelBookData;
	private JComboBox cmbCategory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterNewBorrowerForm window = new RegisterNewBorrowerForm();
					window.frmRegisterNewBorrower.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterNewBorrowerForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegisterNewBorrower = new JFrame();
		frmRegisterNewBorrower.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				//Open main menu form
				MainMenuForm.main(null);
				/*
				 * We don't actually need to call the dispose() method here,
				 * because we've already define it in the "default close operation"
				 * property
				 */
			}
		});
		frmRegisterNewBorrower.setTitle("Register New Borrower");
		frmRegisterNewBorrower.setBounds(100, 100, 450, 300);
		frmRegisterNewBorrower.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegisterNewBorrower.getContentPane().setLayout(null);
		
		JLabel lblCategory = new JLabel("Category: ");
		lblCategory.setBounds(12, 27, 70, 27);
		frmRegisterNewBorrower.getContentPane().add(lblCategory);
		
		cmbCategory = new JComboBox();
		cmbCategory.setModel(new DefaultComboBoxModel(new String[] {"Fiction", "Non-fiction"}));
		cmbCategory.setBounds(110, 29, 110, 22);
		frmRegisterNewBorrower.getContentPane().add(cmbCategory);
		
		JButton btnSearchAvailableBooks = new JButton("Search For Available Books");
		btnSearchAvailableBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Search for available books
				
				//1. Read the category of the wanted book
				char Category = 'F';
				if (cmbCategory.getSelectedIndex()==1) {
					Category = 'N';
				}
				/*
				 * 2. call a static method in the controller to return the name of the available 
				 * books or to display an error message if there is no available books
				 */
				String selectedBook = RegisterNewBorrowerController.searchAvailableBooks(Category);
				
				/*
				 * 3. Check if the selected book is not empty.
				 * (Note: the way of comparing string, wihtout equal sign "==")
				 */
				if (selectedBook.equals("")) {
					JOptionPane.showMessageDialog(null, "There is no avalaiable ward.");
					return;
				}
				txtSelectedBook.setText(selectedBook);
				panelBookData.setVisible(true);
				
			}
		});
		btnSearchAvailableBooks.setBounds(232, 27, 188, 26);
		frmRegisterNewBorrower.getContentPane().add(btnSearchAvailableBooks);
		
		JLabel lblSelectedBook = new JLabel("Selected Book: ");
		lblSelectedBook.setBounds(12, 74, 88, 16);
		frmRegisterNewBorrower.getContentPane().add(lblSelectedBook);
		
		txtSelectedBook = new JTextField();
		txtSelectedBook.setEditable(false);
		txtSelectedBook.setBounds(110, 72, 310, 20);
		frmRegisterNewBorrower.getContentPane().add(txtSelectedBook);
		txtSelectedBook.setColumns(10);
		
		panelBookData = new JPanel();
		panelBookData.setVisible(false);
		panelBookData.setBounds(12, 102, 408, 139);
		frmRegisterNewBorrower.getContentPane().add(panelBookData);
		panelBookData.setLayout(null);
		
		JLabel lblNameOfBorrower = new JLabel("Name Of Borrower: ");
		lblNameOfBorrower.setBounds(12, 12, 120, 27);
		panelBookData.add(lblNameOfBorrower);
		
		txtNameOfBorrower = new JTextField();
		txtNameOfBorrower.setBounds(150, 15, 225, 20);
		panelBookData.add(txtNameOfBorrower);
		txtNameOfBorrower.setColumns(10);
		
		JLabel lblBorrowDate = new JLabel("Borrow Date:");
		lblBorrowDate.setBounds(12, 51, 120, 16);
		panelBookData.add(lblBorrowDate);
		
		txtBorrowDate = new JTextField();
		txtBorrowDate.setBounds(150, 49, 225, 20);
		panelBookData.add(txtBorrowDate);
		txtBorrowDate.setColumns(10);
		
		JButton btnSaveBorrowerData = new JButton("Save Borrower Data");
		btnSaveBorrowerData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// To save borrower data, there are several steps to do
				// 1. Get the data from GUI
				String BorrowerName = txtNameOfBorrower.getText();
				
				/*
				 * 1a. For now, we just create a dummy data without reading the 
				 * date from GUI. Later during the database recording sessions,
				 * we will modify this 
				 * *** Don't forget to import java.util.Date
				 */
				Date BorrowDate = new Date();
				
				// 2. Create borrower data by calling the static method in controller
				RegisterNewBorrowerController.saveBorrowertData(BorrowerName, BorrowDate);
				
				// 3. Get all of patient list by calling a static method in controller
				// 3a. Declare the display string
				String display = "List of all the borrowers of the library: \n\n";
				
				// 3b. Call the static method
				display += RegisterNewBorrowerController.getListOfBorrowers();
				
				// 4. Display the list of all the patient 
				JOptionPane.showMessageDialog(null, display);
				
				// 5. Turn-off the panel, so user must click "Search"
				panelBookData.setVisible(false);
				
			}
		
		});
		btnSaveBorrowerData.setBounds(96, 89, 184, 26);
		panelBookData.add(btnSaveBorrowerData);
	}
}
