
public class Contact {
	private String name;
	private String phoneNumber;
	private String email;
	private String address;
	private String birthday;
	private String notes;

	public Contact(String name, String phoneNumber, String email, String address, String birthDay, String notes) {
		this.name = name;
		this.phoneNumber=phoneNumber;
		this.email = email;
		this.address = address;
		this.birthday = birthDay;
		this.notes = notes;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getNotes() {
		return notes;
	}

	public Contact(Contact c) {
		name = c.name;
		email = c.email;
		address = c.address;
		birthday = c.birthday;
		notes = c.notes;
	}

//	public boolean checkNP(String name , String phoneNumber) {
//		if (name.equals(name) || phoneNumber.equals(phoneNumber))
//			return false;
//		return true;
//	}
//	public boolean equalsContact(Contact c) {//?
//		if (name.equals(c.name) || phoneNumber.equals(c.phoneNumber) || email.equals(c.email)
//				|| address.equals(c.address) || birthday.equals(c.birthday))return true;
//		return false;
//	}
	public boolean equalsContact(String val) {//checks if there's an attribute that matches "val"
		if (name.equals(val) || phoneNumber.equals(val) || email.equals(val)
				|| address.equals(val) || birthday.equals(val))
			return true;
		return false;
	}
	public void printContact() {//print all contact attribute
		System.out.println("\n**************");
		System.out.println("Name:"+name);
		System.out.println("Phone Number:"+phoneNumber);
		System.out.println("Email Address:"+email);
		System.out.println("Address:"+address);
		System.out.println("Birthday:"+birthday);
		System.out.println("Notes:"+notes);
		System.out.println("**************\n");
	}
}
