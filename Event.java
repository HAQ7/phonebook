//CLASS: Event.java

//        CSC212 Data structures - Project phase I
//        Fall 2023
//        EDIT DATE:
//        10-16-2023
//        TEAM:
//        HHM
//        AUTHORS:
//        Hussam Qannam (ID443100831) , Hisham Alsuhaibani (ID443100662) , Mohammed Al Mahmud (ID443101240)

public class Event {
	private String title;
	private String date;
	private String location;
	private String[] contacts;



	private int contactsSize;

	private boolean appointment;

	public Event(String title, String date, String location, String[] contactNames, boolean appointment) {
		this.title = title;
		this.date = date;
		this.location = location;
		this.contacts = contactNames;
		this.contactsSize = contactNames.length;
		this.appointment = appointment;
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
		for (int i = 0; i < contactsSize; i++) {

			if (contact.equalsIgnoreCase(contacts[i]))
				return true;
		}
		return false;
	}

	public void removeContact(String contact) {
		int start = contactsSize;
		for (int i = 0; i < contactsSize; i++) {
			if (contact.equalsIgnoreCase(contacts[i])) {
				start = i;
				break;
			}
		}
		for (int i = start + 1; i < contactsSize; i++) {
			contacts[i - 1] = contacts[i];
		}
		contactsSize--;
	}

	public int getContactsSize() {
		return contactsSize;
	}

	public void printEvent() {
		if (appointment) {
			System.out.println("\n**************");
			System.out.println("Appointment's title: " + title);
			System.out.println("Appointment's date: " + date);
			System.out.println("Appointment's location: " + location);
			System.out.print("Contact's name " + contacts[0]);
			System.out.println();
			System.out.println("**************\n");
			return;
		}
		System.out.println("\n**************");
		System.out.println("Event's title: " + title);
		System.out.println("Event's date: " + date);
		System.out.println("Event's location: " + location);
		System.out.print("Contact's name: " + contacts[0]);
		for (int i = 1; i < contactsSize; i++)
			System.out.print("," + contacts[i]);
		System.out.println();
		System.out.println("**************\n");
	}

}
