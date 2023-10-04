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
				input.nextLine();
				String name = input.nextLine();
				System.out.print("Enter the contact's phone number:");
				String phone = input.next();
				if(test.listC.isUnique(name, phone)) {
				System.out.print("Enter the contact's email address:");
				
				String email = input.next();
				System.out.print("Enter the contact's address: ");
				input.nextLine();
				String address = input.nextLine();
				System.out.print("Enter the contact's birthday:");
				
				String birthDay = input.next();
				System.out.print("Enter any notes for the contact:");
				input.nextLine();
				String notes = input.nextLine();

				test.addContact(name, phone, email, address, birthDay, notes);
				}
				else {
					System.out.println("\nSorry, there's an existed contact that has ethier Name or Phone number\n");
				}
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
					input.nextLine();
					test.listC.searchConatctToPrint(input.nextLine());
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
					input.nextLine();
					test.listC.searchConatctToPrint(input.nextLine());
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
				if(test.listC.empty())
					System.out.println("Sorry, there's no contact.");
				System.out.print("Enter event title:");
				input.nextLine();
				String title = input.nextLine();
				System.out.print("Enter contact name:");
				input.nextLine();
				String contactName = input.nextLine();
				System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");
				input.nextLine();
				String date = input.nextLine();
				System.out.print("Enter event location:");
				input.nextLine();
				String location = input.nextLine();

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
					input.nextLine();
					test.printSharedEventC(input.nextLine());
					break;
				}
				case 2: {
					System.out.print("Enter the event title:");
					input.nextLine();
					test.printSharedEventE(input.nextLine());
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
