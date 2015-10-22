import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class AddressBookSwingGui extends JFrame implements ActionListener {

	private AddressBook addressBook;
	private JList buddies;

	private JMenuItem create, save, add, edit, delete;
	private JMenu buddyMenu, addressMenu;
	
	public AddressBookSwingGui() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 300);

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		buddyMenu = new JMenu("Contact Info");
		addressMenu = new JMenu("Address Book");
		buddyMenu.setEnabled(false);

		menuBar.add(addressMenu);
		menuBar.add(buddyMenu);

		create = new JMenuItem("Create Address Book");
		create.addActionListener(this);

		save = new JMenuItem("Save Address Book");
		save.setEnabled(false);
		save.addActionListener(this);

		add = new JMenuItem("Add New Buddy");
		add.addActionListener(this);
		
		edit = new JMenuItem("Edit Selected Buddy");
		edit.setEnabled(false);
		edit.addActionListener(this);
		
		delete = new JMenuItem("Delete Selected Buddy");
		delete.setEnabled(false);
		delete.addActionListener(this);

		buddyMenu.add(add);
		buddyMenu.add(edit);
		buddyMenu.add(delete);
		addressMenu.add(create);
		addressMenu.add(save);

		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == create) {
			addressBook = new AddressBook();

			buddies = new JList<>(addressBook.buddies);
			add(buddies);
			buddies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			buddyMenu.setEnabled(true);
			save.setEnabled(true);

		}
		else if (event.getSource() == save) {
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("myFile.txt"));
				out.write(addressBook.toString());
				out.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
		else if (event.getSource() == add) {
			edit.setEnabled(true);
			delete.setEnabled(true);
			
			String name = JOptionPane.showInputDialog(null, "What is buddy's name?", "Input Buddy's Name", JOptionPane.QUESTION_MESSAGE);
			int age = Integer.parseInt(JOptionPane.showInputDialog(null, "What is " + name + "'s age?", "Input " + name + "'s Age", JOptionPane.QUESTION_MESSAGE));
			String number = JOptionPane.showInputDialog(null, "What is " + name + "'s phone number?", "Input " + name + "'s Phone Number", JOptionPane.QUESTION_MESSAGE);

			BuddyInfo info = new BuddyInfo(name, age, number);
			addressBook.addBuddy(info);
		}
		else if (event.getSource() == edit) {
			BuddyInfo buddyEdit = addressBook.getBuddy(buddies.getSelectedIndex());
			String nameEdit = buddyEdit.getName();
			
			int editAge = Integer.parseInt(JOptionPane.showInputDialog(null, "What is " + nameEdit + "'s new age?", "Input " + nameEdit + "'s new Age", JOptionPane.QUESTION_MESSAGE));
			String editNumber = JOptionPane.showInputDialog(null, "What is " + nameEdit + "'s new phone number?", "Input " + nameEdit+ "'s new Phone Number", JOptionPane.QUESTION_MESSAGE);
			
			buddyEdit.setAge(editAge);
			buddyEdit.setPhoneNumber(editNumber);
		}
		else if (event.getSource() == delete) {
			addressBook.removeBuddy(buddies.getSelectedIndex());
		}
	}


	public static void main(String args[]) {
		new AddressBookSwingGui();
	}

}
