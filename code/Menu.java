package code;
//CLASS: Menu.java
//        CSC212 Data structures - Project phase I
//        Fall 2023
//        EDIT DATE:
//        10-16-2023
//        TEAM:
//        HHM
//        AUTHORS:
//        Hussam Qannam (ID443100831) , Hisham Alsuhaibani (ID443100662) , Mohammed Al Mahmud (ID443101240)

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome !\n\n");
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
                        phonebook.addEvent();
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
                        phonebook.printSharedContactE();
                        break;
                    }
                    case 8: {
                        phonebook.printEvents();
                        break;
                    }
                    case 9: {
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

        } while (option != 9);
        System.out.println("\n\nThank you !");
        phonebook.input.close();
        input.close();

    }

}
