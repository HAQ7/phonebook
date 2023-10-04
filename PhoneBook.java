import java.util.Scanner;

public class PhoneBook {

	LinkedList<Event> listE = new LinkedList<Event>();
	LinkedList<Contact> listC = new LinkedList<Contact>();

	public void addContact(String name, String phoneNumber, String email, String address, String birthday,
			String notes) 
	{		
			Contact temp = new Contact(name, phoneNumber, email, address, birthday, notes);
			listC.insertSortedC(name, temp);
			System.out.println("\nThe contact was added successfully.\n");
		
	}

	public void printContact(String val) {// print all contact that have the same value
		int count = 0;
		listC.findFirst();
		while (!listC.last()) {
			if (listC.retrieve().equalsContact(val))
				System.out.println(++count + ". ");
			listC.retrieve().printContact();
			listC.findNext();
		}
		if (listC.retrieve().equalsContact(val))
			listC.retrieve().printContact();
		if (count < 1)
			System.out.println("No contact was found.");
	}

	public void printSharedEventE(String eventName) {// print all events that share "eventName"
		listE.findFirst();
		int count = 0;
		System.out.println("\nThe event \"" + eventName + "\" is shared with:");
		while (!listE.last()) {
			if (listE.retrieve().getTitle().equals(eventName)) {
				System.out.println(++count + ". ");
				listE.retrieve().printEvent();
			}
			listE.findNext();
		}
		if (listE.retrieve().getTitle().equals(eventName)) {
			System.out.println(++count + ". ");
			listE.retrieve().printEvent();
		}
		if (count == 0)
			System.out.println("\nSorry, no one have the Event name : \"" + eventName + "\".\n");
	}

	public void printSharedEventC(String contactName) {// print all events that share "contactName"
		listE.findFirst();
		int count = 0;
		System.out.println("\nThe contact name \"" + contactName + "\" is shared event:");
		while (!listE.last()) {
			if (listE.retrieve().getContactName().equals(contactName)) {
				System.out.println(++count + ". ");
				listE.retrieve().printEvent();
			}
			listE.findNext();
		}
		if (listE.retrieve().getContactName().equals(contactName)) {
			System.out.println(++count + ". ");
			listE.retrieve().printEvent();
		}
		if (count == 0)
			System.out.println("\nSorry, there's no event has the Contact name : \"" + contactName + "\".\n");
	}

	public void printFirstNameContact(String name) {// print all contacts that have first name matches "name"
		listC.findFirst();
		int count = 0;
		System.out.println("\nThe contact that has \"" + name + "\" as a first name:");
		while (!listC.last()) {

			if (listC.retrieve().getName().substring(0, name.length()).equals(name)) {
				System.out.println(++count + ". \n********");
				listC.retrieve().printContact();
				System.out.println("********\n");
				listC.findFirst();

			}
			listC.findNext();
		}
		if (listC.retrieve().getName().substring(0, name.length() - 1).equals(name)) {
			System.out.println(++count + ". \n********");
			listC.retrieve().printContact();
			System.out.println("********\n");
		}
		if (count == 0)
			System.out.println("\nThere's no contact that has \"" + name + "\" as a first name.\n");
	}

	public void deleteContact() {// print available contacts and allow user to choose one of them and delete chosen contact and the related event (if exist)
		if (listC.empty()) {
			System.out.println("\nThe list is empty!\n");
			return;
		}
		Scanner input = new Scanner(System.in);
		int count = listC.printNameAndPH();
		System.out.print("\nPlease choose the contact number:");
		int num = input.nextInt();
		String temp = "";
		listC.findFirst();
		if (num > count || num < 1) {
			System.out.println("Sorry, you've entered an incrorect number.");
			return;
		}
		else if(num==1) {
			temp = listC.retrieve().getName();
			listC.remove();
			System.out.println("\nThe contact was deleted successfully\n");
		}
		else {
			listC.findNext();
			int index = 2;//because the first element =1
			while (!listC.last()) {
				if ((index++) == num) {
					temp = listC.retrieve().getName();
					listC.remove();
					System.out.println("\nThe contact was deleted successfully\n");
					break;
				}
				listC.findNext();
			}
			if (index == num) {
				temp = listC.retrieve().getName();
				listC.remove();
				System.out.println("\nThe contact was deleted successfully\n");
			}
		}
		if (!listE.empty()) {
			listE.findFirst();
			while (!listE.last()) {
				if (listE.retrieve().getContactName().equals(temp))
					listE.remove();
				listE.findNext();
			}

			if (listE.retrieve().getContactName().equals(temp))
				listE.remove();
		}
	}

	public void addEvent(String title, String date, String location, String contactName) {// add event
		listC.findFirst();
		while (!listC.last()) {
			if (listC.retrieve().equalsContact(contactName) && !isConflict(date)) {// check if the contact exist
				Event temp = new Event(title, date, location, contactName);
				listE.insertSortedE(title, temp);
				System.out.println("\nThe event was added successfully.\n");
				return;
			}
			listC.findNext();
		}
		if (listC.retrieve().equalsContact(contactName) && !isConflict(date)) {
			Event temp = new Event(title, date, location, contactName);
			listE.insert(temp);
			System.out.println("\nThe event was added successfully.");
			return;
		}
		System.out.println("\nThere's no contact exsit with name : \"" + contactName + "\" .\n");
	}

	public boolean isConflict(String date) {// Check if there's a date conflict
		if (listE.empty())
			return false;
		listE.findFirst();
		while (!listE.last()) {
			if (listE.retrieve().getDate().equals(date))
				return true;
			listE.findNext();
		}
		if (listE.retrieve().getDate().equals(date))
			return true;
		return false;

	}

	public void printEvents() {// print all events
		if (listE.empty()) {
			System.out.println("\nThere's no events to print.\n");
			return;
		}
		listE.findFirst();
		while (!listE.last()) {
			listE.retrieve().printEvent();
			listE.findNext();
		}
		listE.retrieve().printEvent();
		System.out.println("\nAll events have printed successfully!\n");
	}

	public void printMenu() {// print menu
		System.out.println("Please choose one of the following options:");
		System.out.println("1.Add a new contact.");
		System.out.println("2.Search for a contact.");
		System.out.println("3.Delete a contact.");
		System.out.println("4.Schedule an event.");
		System.out.println("5.Print event details.");
		System.out.println("6.Print contacts by first name.");
		System.out.println("7. Print all events alphabetically.");
		System.out.println("8.Exit\n");
		System.out.print("Enter choice:");
	}

	public void printAllContact() {// just for testing that all contact are sorted. DELETE IT AFTER TESTING!!!!
		listC.findFirst();
		while (!listC.last()) {
			listC.retrieve().printContact();
			listC.findNext();
		}

		listC.retrieve().printContact();
	}
}
