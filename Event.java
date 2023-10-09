
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
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public int compareTo(Event e) {
		return title.toLowerCase().compareTo(e.title.toLowerCase());
	}

	public void printEvent() {//print all event attribute
	System.out.println("\n**************");
	System.out.println("Event's title:"+title);
	System.out.println("Event's date:"+date);
	System.out.println("Event's location:"+location);
	System.out.println("Contact's name:"+contactName);
	System.out.println("**************\n");
	}
	
}
