package com.mercubuana.week06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuForm {

	private JFrame frmNationalLibraryInformation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuForm window = new MainMenuForm();
					window.frmNationalLibraryInformation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenuForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNationalLibraryInformation = new JFrame();
		frmNationalLibraryInformation.setTitle("ABC Library Information System");
		frmNationalLibraryInformation.setBounds(100, 100, 450, 300);
		frmNationalLibraryInformation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNationalLibraryInformation.getContentPane().setLayout(null);
		
		JButton btnAddNewBook = new JButton("Add New Book");
		btnAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewBookDataForm.main(null);
				frmNationalLibraryInformation.dispose();
			}
		});
		btnAddNewBook.setBounds(136, 77, 155, 30);
		frmNationalLibraryInformation.getContentPane().add(btnAddNewBook);
		
		JButton btnRegisterNewBorrower = new JButton("Register New Borrower");
		btnRegisterNewBorrower.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterNewBorrowerForm.main(null);
				frmNationalLibraryInformation.dispose();
			}
		});
		btnRegisterNewBorrower.setBounds(124, 143, 181, 26);
		frmNationalLibraryInformation.getContentPane().add(btnRegisterNewBorrower);
	}
}
