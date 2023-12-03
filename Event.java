//CLASS: Event.java

//        CSC212 Data structures - Project phase II
//        Fall 2023
//        EDIT DATE:
//        12-2-2023
//        TEAM:
//        HHM
//        AUTHORS:
//        Hussam Qannam (ID443100831) , Hisham Alsuhaibani (ID443100662) , Mohammed Al Mahmud (ID443101240)

public class Event {
	private String title;
	private String date;
	private String location;


	private String contacts;
	private final boolean appointment;

	public Event(String title, String date, String location, String contactNames, boolean appointment) {
		this.title = title;
		this.date = date;
		this.location = location;
		this.contacts = contactNames;
		this.appointment = appointment;
	}
	public String getContacts() {
		return contacts;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public boolean isAppointment() {
		return appointment;
	}


	// returns true if it exists else returns false;
	public boolean includesContact(String contact) {
		return contacts.contains(contact);
	}

	public void removeContact(String contact) {
		contacts = contacts.replace(contact + ",","");
		contacts = contacts.replace(contact,"");
	}


	public void printEvent() {
		if (appointment) {
			System.out.println("\n**************");
			System.out.println("Appointment's title: " + title);
			System.out.println("Appointment's date: " + date);
			System.out.println("Appointment's location: " + location);
			System.out.print("Contact's name: " + contacts);
			System.out.println();
			System.out.println("**************\n");
			return;
		}
		System.out.println("\n**************");
		System.out.println("Event's title: " + title);
		System.out.println("Event's date: " + date);
		System.out.println("Event's location: " + location);
		System.out.print("Contacts: " + contacts);
		System.out.println();
		System.out.println("**************\n");
	}

}
