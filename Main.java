import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome !\n\n");
		int option;

		PhoneBook test = new PhoneBook();
		do {
			System.out.println();
			test.printMenu();
			option = input.nextInt();
			System.out.println();
			switch (option) {
			case 1: {
				System.out.print("Enter the contact's name:");
				String name = input.next();
				System.out.print("Enter the contact's phone number:");
				String phone = input.next();
				System.out.print("Enter the contact's email address:");
				String email = input.next();
				System.out.print("Enter the contact's address: ");
				String address = input.next();
				System.out.print("Enter the contact's birthday:");
				String birthDay = input.next();
				System.out.print("Enter any notes for the contact:");
				String notes = input.next();

				test.addContact(name, phone, email, address, birthDay, notes);
				break;
			}
			case 2: {
				if (test.listC.empty()) {
					System.out.println("There's no contacts.");
					break;
				}
				System.out.println("Enter search criteria:\r\n" + "1. Name\r\n" + "2. Phone Number\r\n"
						+ "3. Email Address\r\n" + "4. Address\r\n" + "5. Birthday");
				System.out.print("Enter choice:");
				option = input.nextInt();
				switch (option) {
				case 1: {
					System.out.print("Enter contact's name:");
					test.listC.searchConatctToPrint(input.next());
					break;
				}
				case 2: {
					System.out.print("Enter contact's Phone Number:");
					test.listC.searchConatctToPrint(input.next());
					break;
				}
				case 3: {
					System.out.print("Enter contact's Email Address:");
					test.listC.searchConatctToPrint(input.next());
					break;
				}
				case 4: {
					System.out.print("Enter contact's Address:");
					test.listC.searchConatctToPrint(input.next());
					break;
				}
				case 5: {
					System.out.print("Enter contact's Birthday:");
					test.listC.searchConatctToPrint(input.next());
					break;
				}
				default: {
					System.out.println("Sorry, make sure that you've entered a correct option.");
				}
				}
				break;
			}
			case 3: {
				test.deleteContact();
				break;
			}
			case 4: {
				System.out.print("Enter event title:");
				String title = input.next();
				System.out.print("Enter contact name:");
				String contactName = input.next();
				System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");
				String date = input.next();
				System.out.print("Enter event location:");
				String location = input.next();

				test.addEvent(title, date, location, contactName);
				break;
			}
			case 5: {
				if (test.listE.empty()) {
					System.out.println("\nSorry there's no events!\n");
					break;
				}
				System.out.println("Enter search criteria:");
				System.out.println("1. Contact name");
				System.out.println("2. Event tittle");
				System.out.print("Enter choice:");
				option = input.nextInt();
				switch (option) {
				case 1: {
					System.out.print("Enter contact's name:");
					test.printSharedEventC(input.next());
					break;
				}
				case 2: {
					System.out.print("Enter the event title:");
					test.printSharedEventE(input.next());
					break;
				}
				default: {
					System.out.println("\nSorry, make sure that you've entered a correct option.\n");
				}
				}
				break;
			}
			case 6: {
				if (test.listC.empty()) {
					System.out.println("\nSorry there's no contacts!\n");
					break;
				}
				System.out.print("Enter the first name:");
				test.printFirstNameContact(input.next());
				break;
			}
			case 7: {
				test.printEvents();
				break;
			}
			case 8: {
				break;
			}
			default: {
				System.out.println("\nSorry, make sure that you've entered a correct option.\n");
			}
			}
		} while (option != 8);
		System.out.println("\n\nThank you !");
		

	}

}
