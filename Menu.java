
//CLASS: Menu.java
//        CSC212 Data structures - Project phase II
//        Fall 2023
//        EDIT DATE:
//        12-2-2023
//        TEAM:
//        HHM
//        AUTHORS:
//        Hussam Qannam (ID443100831) , Hisham Alsuhaibani (ID443100662) , Mohammed Al Mahmud (ID443101240)

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the BST Phonebook!\n\n");
		int option;

		PhoneBook phonebook = new PhoneBook();
		do {
			phonebook.menu();
			System.out.print("Enter choice:");
			try {
				option = input.nextInt();
				input.nextLine();
				System.out.println();
				switch (option) {
				case 1: {
					phonebook.addContact();
					break;
				}
				case 2: {
					phonebook.searchContact();
					break;
				}
				case 3: {
					phonebook.deleteContact();
					break;
				}
				case 4: {
					System.out.println("Enter type:");
					System.out.println("1.event");
					System.out.println("2.appointment");
					System.out.println();
					System.out.print("Enter your choice:");
					int type = input.nextInt();
					input.nextLine();
					if (type == 1) {
						phonebook.addEvent();

					} else if (type == 2) {
						phonebook.addAppointment();

					}
					break;
				}
				case 5: {
					phonebook.searchEvent();
					break;
				}
				case 6: {
					phonebook.printFirstNameContact();
					break;
				}

				case 7: {
					phonebook.printEvents();
					break;
				}
				case 8: {
					break;
				}
				default: {
					System.out.println("\nSorry, make sure that you've entered a correct option.\n");
				}
				}
			} catch (Exception e) {
				System.out.println("\nSorry, make sure that you've entered a correct option.\n");
				option = 0;
				input.nextLine();
			}

		} while (option != 8);
		System.out.println("\n\nThank you !");
		phonebook.input.close();
		input.close();

	}

}
