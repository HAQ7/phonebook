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
        } while (option != 8);
        System.out.println("\n\nThank you !");
        phonebook.input.close();
        input.close();

    }

}
