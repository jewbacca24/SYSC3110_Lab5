

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BuddyInfoTest {
	
	BuddyInfo lukeSkywalker;
	BuddyInfo hanSolo;
	BuddyInfo hanClono;
	BuddyInfo yodaForceGhost;
	
	@Before
	public void setUp() throws Exception {
		lukeSkywalker = new BuddyInfo("Luke Skywalker", 17, "987654321");
		hanSolo = new BuddyInfo("Han Solo", 73, "123456789");
		hanClono = new BuddyInfo(hanSolo);
		yodaForceGhost = new BuddyInfo();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBuddyInfoStringIntString() {
		BuddyInfo hanSolo2 = new BuddyInfo("Han Solo", 73, "123456789");
		assertEquals("Han Solo equals HanSolo2", hanSolo2, hanSolo);
	}

	@Test
	public void testBuddyInfoBuddyInfo() {
		assertEquals("Han Clono is a clone of Han Solo", hanClono, hanSolo);
	}

	@Test
	public void testBuddyInfo() {
		assertNotNull("Yoda Force Ghost is not null", yodaForceGhost);
	}

	@Test
	public void testGetName() {
		assertEquals("Luke Skywalker's name should be Luke Skywalker", "Luke Skywalker", lukeSkywalker.getName());
	}

	@Test
	public void testSetName() {
		lukeSkywalker.setName("Impatient Child");
		assertEquals("Luke's new name is Impatient Child", "Impatient Child", lukeSkywalker.getName());
	}

	@Test
	public void testGetAge() {
		assertEquals("Han Solo is 73 years old", 73, hanSolo.getAge());
	}

	@Test
	public void testSetAge() {
		lukeSkywalker.setAge(12);
		assertEquals("Luke's new age is 12", 12, lukeSkywalker.getAge());
	}

	@Test
	public void testIsOver18() {
		assertTrue("Han Clono is over 18", hanClono.isOver18());
		assertFalse("Luke Skywalker is under 18", lukeSkywalker.isOver18());
	}

	@Test
	public void testGetPhoneNumber() {
		assertEquals("Han Solo's number is 123456789", "123456789", hanSolo.getPhoneNumber());
	}

	@Test
	public void testSetPhoneNumber() {
		lukeSkywalker.setPhoneNumber("111222333");
		assertEquals("Luke Skywalker's new number is 111222333", "111222333", lukeSkywalker.getPhoneNumber());
	}

	@Test
	public void testToString() {
		assertEquals("toString output is:\n\"Name: Han Solo\n Age: 73\n Phone Number: 111222333\n", 
				"Name: " + hanSolo.getName() + "\n Age: " + hanSolo.getAge() + "\n Phone Number: " + hanSolo.getPhoneNumber() + "\n",
				hanSolo.toString()
				);
	}
	
	@Test
	public void testEquals() {
		assertTrue("Han Solo and Han Clono are the same", hanSolo.equals(hanClono));
		assertFalse("Han Solo and Luke Skywalker are not the same", hanSolo.equals(lukeSkywalker));
		assertFalse("Han Solo and null are not the same", hanSolo.equals(null));
		assertFalse("Han Solo and Yoda Force Ghost are not the same", hanSolo.equals(yodaForceGhost));
	}

	@Test
	public void testGetGreeting() {
		assertEquals("Han Clono's greeting is: Hello Han Clono!", "Hello Han Solo!", hanClono.getGreeting());
	}

}
