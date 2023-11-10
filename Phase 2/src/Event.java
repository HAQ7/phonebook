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
	private String contactName;

	public Event(String title, String date, String location, String contactName) {
		this.title = title;
		this.date = date;
		this.location = location;
		this.contactName = contactName;
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

	public String getContactName() {
		return contactName;
	}

//	public void setContactName(String contactName) {
//		this.contactName = contactName;
//	}

	public void printEvent() {// print all event attribute
		System.out.println("\n**************");
		System.out.println("Event's title:" + title);
		System.out.println("Event's date:" + date);
		System.out.println("Event's location:" + location);
		System.out.print("Contact's name:" + contactName);
		System.out.println();
		System.out.println("**************\n");
	}

}
