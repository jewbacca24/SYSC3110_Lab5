import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class AddressBookTest {
	
	AddressBook book;
	BuddyInfo hanSolo;
	BuddyInfo hanClono;

	@Before
	public void setUp() throws Exception {
		book = new AddressBook();
		hanSolo = new BuddyInfo("Han Solo", 73, "123456789");
		hanClono = new BuddyInfo(hanSolo);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddressBook() {
		assertNotNull("Address Book class is not null", book);
		assertNotNull("Address Book's book is not null", book.buddies);
	}

	@Test
	public void testSize() {
		assertEquals("Size of Address Book is 0", 0, book.size());
		book.addBuddy(hanSolo);
		assertEquals("Size of Address Book is 1", 1, book.size());
	}

	@Test
	public void testClear() {
		book.addBuddy(hanClono);
		book.clear();
		assertEquals("Size of Address Book is 0", 0, book.size());
	}

	@Test
	public void testAddBuddy() {
		assertEquals("Size of Address Book is 0", 0, book.size());
		book.addBuddy(hanSolo);
		assertEquals("Size of Address Book is 1", 1, book.size());
	}

	@Test
	public void testRemoveBuddy() {
		book.addBuddy(hanSolo);
		assertEquals("Size of Address Book is 1", 1, book.size());
		book.removeBuddy(0);
		assertEquals("Size of Address Book is 0", 0, book.size());
	}
	
	@Test
	public void testGetBuddy() {
		book.addBuddy(hanSolo);
		BuddyInfo getBud = book.getBuddy(0);
		assertEquals("Buddy from getBuddy is the same as Han Solo", getBud, hanSolo);
		
	}

	//Name: " + name + "\n Age: " + age + "\n Phone Number: " + number + "\n"
	@Test
	public void testToString() {
		book.addBuddy(hanSolo);
		book.addBuddy(hanClono);
		assertEquals("The toString should be as follows",
						"Buddie(s):\nName: Han Solo\n Age: 73\n Phone Number: 123456789\n"
						+ "\nName: Han Solo\n Age: 73\n Phone Number: 123456789\n\n",
						book.toString());
	}


}
