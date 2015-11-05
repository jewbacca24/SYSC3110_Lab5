
public class BuddyInfo {
	
	private String name;
	private int age;
	private String number;
	
	public BuddyInfo(String name, int age, String number) {
		this.name = name;
		this.age = age;
		this.number = number;
	}
	
	public BuddyInfo(BuddyInfo buddyClone) {
		this.name = buddyClone.name;
		this.age = buddyClone.age;
		this.number = buddyClone.number;
	}
	
	public BuddyInfo() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean isOver18() {
		return (age >= 18);
	}

	public String getPhoneNumber() {
		return number;
	}

	public void setPhoneNumber(String number) {
		this.number = number;
	}
	
	public String toString() {
		return "Name: " + name + "\n Age: " + age + "\n Phone Number: " + number + "\n";
	}
	
	public String getGreeting() {
		return "Hello " + name + "!";
	}
	
	public boolean equals(Object obj) {
		if (null == obj) return false;
		if ( !(obj instanceof BuddyInfo) ) return false;
		
		BuddyInfo buddy = (BuddyInfo) obj;
		return this.name.equals(buddy.name) && (this.age == buddy.age) && this.number.equals(buddy.number); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuddyInfo buddy = new BuddyInfo();
		buddy.setName("Noah");
		buddy.setAge(19);
		buddy.setPhoneNumber("123456789");
		
		System.out.println("Howdy " + buddy.getName());
	}

}
