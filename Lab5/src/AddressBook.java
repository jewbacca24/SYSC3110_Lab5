import java.util.ArrayList;
import javax.swing.*;

public class AddressBook {

	public DefaultListModel<BuddyInfo> buddies;
	
	public AddressBook() {
		buddies = new DefaultListModel<BuddyInfo>();
	}
	
	public void addBuddy(BuddyInfo newBuddy) {
		buddies.addElement(newBuddy);
	}
	
	public void removeBuddy(int i) {
		if (i >= 0 && i < buddies.size()) {
			buddies.remove(i);
		}	
	}
	
	public BuddyInfo getBuddy(int i) {
		if (i >= 0 && i < buddies.size()) {
			return buddies.getElementAt(i);
		}
		return null;
	}
	
	public String toString() {
		String s = "Buddie(s):\n";
		for (int i = 0; i < buddies.size(); i++) {
			s += buddies.get(i) + "\n";
		}
		return s;
	}
	
	public static void main(String[] args) {
		System.out.println("Address Book");
		
		BuddyInfo newBud = new BuddyInfo("Noah", 24, "123456789");
		AddressBook newBook = new AddressBook();
		newBook.addBuddy(newBud);
		newBook.removeBuddy(0);
	}
	
}
