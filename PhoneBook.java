
//CLASS: PhoneBook.java
//        CSC212 Data structures - Project phase II
//        Fall 2023
//        EDIT DATE:
//        12-2-2023
//        TEAM:
//        HHM
//        AUTHORS:
//        Hussam Qannam (ID443100831) , Hisham Alsuhaibani (ID443100662) , Mohammed Al Mahmud (ID443101240)

import java.util.Scanner;

public class PhoneBook {

	LinkedList<Event> listE = new LinkedList<Event>();
	ContactBST<Contact> bstC = new ContactBST<Contact>();

	public Scanner input = new Scanner(System.in);


	public void addContact() { 
		System.out.print("Enter the contact's name:");
		String name = input.nextLine();
		System.out.print("Enter the contact's phone number:");
		String phone = input.next();

		System.out.print("Enter the contact's email address:");

		String email = input.next();
		System.out.print("Enter the contact's address:");
		input.nextLine();
		String address = input.nextLine();
		System.out.print("Enter the contact's birthday:");

		String birthDay = input.next();
		System.out.print("Enter any notes for the contact:");
		input.nextLine();
		String notes = input.nextLine();
		if (bstC.isUnique(phone)) {
			Contact temp = new Contact(name, phone, email, address, birthDay, notes);

			if (bstC.insert(name, temp)) {
			System.out.println("\nThe contact was added successfully.\n");
			return;
			}
		}
		System.out.println("\nSorry, there's an existed contact that has the same Name or Phone number\n");
	}


	public void searchContact() { 
		if (bstC.empty()) {
			System.out.println("There's no contacts.");
			return;
		}
		System.out.println("""
				Enter search criteria:\r
				1. Name\r
				2. Phone Number\r
				3. Email Address\r
				4. Address\r
				5. Birthday""");
		System.out.print("Enter choice:");
		try {
			int option = input.nextInt();
			input.nextLine();
			switch (option) {
			case 1: {
				System.out.print("Enter contact's name:");
				if (bstC.findkey(input.nextLine())) {
					bstC.retrieve().printContact();
				} else {
					System.out.println("Contact not found!");
				}
					break;
			}
			case 2: {
				System.out.print("Enter contact's Phone Number:");
				bstC.searchContact(input.nextLine(), SearchType.phone);
				break;
			}
			case 3: {
				System.out.print("Enter contact's Email Address:");
				bstC.searchContact(input.nextLine(), SearchType.email);
				break;
			}
			case 4: {
				System.out.print("Enter contact's Address:");

				bstC.searchContact(input.nextLine(), SearchType.address);
				break;
			}
			case 5: {
				System.out.print("Enter contact's Birthday:");
				bstC.searchContact(input.nextLine(), SearchType.birthday);
				break;
			}
			default: {
				System.out.println("Sorry, make sure that you've entered a correct option.");
			}
			}
		} catch (Exception e) {
			System.out.println("Sorry, make sure that you've entered a correct option.");
			input.nextLine();
		}

	}

	public void printFirstNameContact() {
		if (bstC.empty()) {
			System.out.println("\nSorry there's no contacts!\n");
			return;
		}
		System.out.print("Enter the first name:");
		String name = input.next();
		input.nextLine();
		System.out.println("\nThe contact that has \"" + name + "\" as a first name:");
		bstC.printFirstNameContact(name);

	}


	public void deleteContact() {
		if (bstC.empty()) {
			System.out.println("\nThe list is empty!\n");
			return;
		}

		System.out.print("\nPlease enter the contact name:");
		String name = input.nextLine();
		if (bstC.removeKey(name))
			System.out.println("\nThe contact was deleted successfully\n");
		else {
			System.out.println("\nThe contact not found\n");
			return;

		}

		// to remove the event related to the contact
		if (!listE.empty()) {
			listE.findFirst();
			while (!listE.last()) {
				if (listE.retrieve().includesContact(name)) {
					if (listE.retrieve().isAppointment()) {
						listE.remove();
						continue;
					}
					else {
						listE.retrieve().removeContact(name);
						if (listE.retrieve().getContacts().isEmpty()) {
							listE.remove();
							continue;
						}
					}
				}
				listE.findNext();
			}
			if (listE.retrieve().includesContact(name)) {
				if (listE.retrieve().isAppointment())
					listE.remove();
				else {
					listE.retrieve().removeContact(name);
					if (listE.retrieve().getContacts().isEmpty())
						listE.remove();
				}
			}

		}

	}


	// Check if there's a date conflict
	public boolean isConflict(String date) {
		if (listE.empty())
			return false;
		listE.findFirst();
		while (!listE.last()) {
			if (listE.retrieve().getDate().equals(date))
				return true;
			listE.findNext();
		}
		return listE.retrieve().getDate().equals(date);

	}



	public void addEvent() {
		System.out.print("Enter event title:");
		String title = input.nextLine();
		System.out.print("Enter contacts name separated by a comma:");
		String contactName = input.nextLine();
		String[] contactNameArray = contactName.split(",");
		System.out.print("Enter event date and time  MM/DD/YYYY HH:MM :");
		String dateAndTime = input.nextLine();

		System.out.print("Enter event location:");
		String location = input.nextLine();
		if (isConflict(dateAndTime)) {
			System.out.println("there is a conflict at that time");
			return;
		}
		for (int i = 0; i < contactNameArray.length; i++) {
			if (!bstC.findkey(contactNameArray[i])) {// check if the contact exist
				System.out.println("\nThere's no contact exist with that name : \"" + contactNameArray[i] + "\" .\n");
				return;
			}
		}
		Event temp = new Event(title, dateAndTime, location, contactName, false);
		listE.insertSorted(title, temp);
		System.out.println("\nThe event was added successfully.\n");
	}

	public void addAppointment() {
		System.out.print("Enter appointment title:");
		String title = input.nextLine();
		System.out.print("Enter contact name:");
		String contactName = input.nextLine();
		System.out.print("Enter appointment date and time (MM/DD/YYYY HH:MM):");
		String date = input.nextLine();
		System.out.print("Enter appointment location:");
		String location = input.nextLine();

		if (isConflict(date)) {
			System.out.println("there is a conflict at that time");
			return;
		}

		if (!bstC.findkey(contactName)) {
			System.out.println("\nThere's no contact exist with that name : \"" + contactName + "\" .\n");
			return;
		}

		Event temp = new Event(title, date, location, contactName, true);
		listE.insertSorted(title, temp);
		System.out.println("\nThe event was added successfully.\n");
	}

	public void searchEvent() {
		if (listE.empty()) {
			System.out.println("\nSorry there's no events!\n");
			return;
		}
		System.out.println("Enter search criteria:");
		System.out.println("1. Contact name");
		System.out.println("2. Event title");
		System.out.print("Enter choice:");
		try {
			int option = input.nextInt();
			switch (option) {
			case 1: {
				System.out.print("Enter contact's name:");
				input.nextLine();
				printSharedEventC(input.nextLine());
				break;
			}
			case 2: {
				System.out.print("Enter the event title:");
				input.nextLine();
				printSharedEventE(input.nextLine());
				break;
			}
			default: {
				System.out.println("\nSorry, make sure that you've entered a correct option.\n");
			}
			}
		} catch (Exception e) {
			System.out.println("\nSorry, make sure that you've entered a correct option.\n");
		}

	}

	// print all events
	public void printEvents() {
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

	// print all events that share "contactName"
	public void printSharedEventC(String contactName) {
		listE.findFirst();
		int count = 0;
		System.out.println("\nThe contact name \"" + contactName + "\" event's are:");
		while (!listE.last()) {
			if (listE.retrieve().includesContact(contactName)) {
				System.out.println(++count + ". ");
				listE.retrieve().printEvent();
			}
			listE.findNext();
		}
		if (listE.retrieve().includesContact(contactName)) {
			System.out.println(++count + ". ");
			listE.retrieve().printEvent();
		}
		if (count == 0)
			System.out.println("\nSorry, there's no event has the Contact name : \"" + contactName + "\".\n");
	}


	// print all events that share "eventTitle"
	public void printSharedEventE(String eventTitle) {
		listE.findFirst();
		int count = 0;
		System.out.println("\nThe event \"" + eventTitle + "\" is shared with:");
		while (!listE.last()) {
			if (listE.retrieve().getTitle().equals(eventTitle)) {
				System.out.println(++count + ". ");
				listE.retrieve().printEvent();
			}
			listE.findNext();
		}
		if (listE.retrieve().getTitle().equals(eventTitle)) {
			System.out.println(++count + ". ");
			listE.retrieve().printEvent();
		}
		if (count == 0)
			System.out.println("\nSorry, no one have the Event name : \"" + eventTitle + "\".\n");
	}

	public void menu() {
		System.out.println();
		System.out.println("Please choose an option:");
		System.out.println("1.Add a new contact");
		System.out.println("2.Search for a contact");
		System.out.println("3.Delete a contact");
		System.out.println("4.Schedule an event/appointment");
		System.out.println("5.Print event details");
		System.out.println("6.Print contacts by first name");
		System.out.println("7.Print all events alphabetically");
		System.out.println("8.Exit\n");
	}

}
