import java.util.Scanner;

public class PhoneBook {

    LinkedList<Event> listE = new LinkedList<Event>();
    LinkedList<Contact> listC = new LinkedList<Contact>();

    public Scanner input = new Scanner(System.in);

    //check if there is an existing contact that holds name and phone number
    public boolean isUnique(String name, String phoneNumber) {
        if (listC.empty()) return true;
        listC.findFirst();
        while (!listC.last()) {
            if ( listC.retrieve().getName().equals(name) || listC.retrieve().getPhoneNumber().equals(phoneNumber))
                return false;
            listC.findNext();
        }
        return !listC.retrieve().getName().equals(name) && !listC.retrieve().getPhoneNumber().equals(phoneNumber);
    }

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
        if (isUnique(name, phone)) {
            Contact temp = new Contact(name, phone, email, address, birthDay, notes);
            listC.insertSortedC(name, temp);
            System.out.println("\nThe contact was added successfully.\n");
            return;
        }
        System.out.println("\nSorry, there's an existed contact that has either Name or Phone number\n");
    }

    public void searchContact() {
        if (listC.empty()) {
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
        int option = input.nextInt();
        switch (option) {
            case 1: {
                System.out.print("Enter contact's name:");
                input.nextLine();
                listC.searchContact(input.nextLine(), SearchType.name);
                break;
            }
            case 2: {
                System.out.print("Enter contact's Phone Number:");

                listC.searchContact(input.next(), SearchType.phone);
                break;
            }
            case 3: {
                System.out.print("Enter contact's Email Address:");

                listC.searchContact(input.next(), SearchType.email);
                break;
            }
            case 4: {
                System.out.print("Enter contact's Address:");
                input.nextLine();
                listC.searchContact(input.nextLine(), SearchType.address);
                break;
            }
            case 5: {
                System.out.print("Enter contact's Birthday:");

                listC.searchContact(input.next(), SearchType.birthday);
                break;
            }
            default: {
                System.out.println("Sorry, make sure that you've entered a correct option.");
            }
        }

    }

    public void printFirstNameContact() {
        if (listC.empty()) {
            System.out.println("\nSorry there's no contacts!\n");
            return;
        }
        System.out.print("Enter the first name:");
        String name = input.next();
        input.nextLine();
        listC.findFirst();
        int count = 0;
        System.out.println("\nThe contact that has \"" + name + "\" as a first name:");
        while (!listC.last()) {

            if (listC.retrieve().getName().substring(0, name.length()).equals(name)) {
                System.out.println(++count + ". \n********");
                listC.retrieve().printContact();
                System.out.println("********\n");

            }
            listC.findNext();
        }
        if (listC.retrieve().getName().substring(0, name.length()).equals(name)) {
            System.out.println(++count + ". \n********");
            listC.retrieve().printContact();
            System.out.println("********\n");
        }
        if (count == 0)
            System.out.println("\nThere's no contact that has \"" + name + "\" as a first name.\n");
    }
    //prints name and phone number

    public int printNameAndPH() {
        listC.findFirst();
        int count = 0;
        System.out.println("************************");
        while (!listC.last()) {

            System.out.println("Contact " + (1 + count) + " :");
            System.out.println("Name is \"" +  listC.retrieve().getName() + "\" .");
            System.out.println("Phone Number is \"" + listC.retrieve().getPhoneNumber() + "\" .");
            System.out.println("************************");
            count++;
            listC.findNext();
        }
        System.out.println("Contact " + (1 + count) + " :");
        System.out.println("Name is \"" +  listC.retrieve().getName() + "\" .");
        System.out.println("Phone Number is \"" + listC.retrieve().getPhoneNumber() + "\" .");
        System.out.println("************************");
        count++;
        return count;
    }


    public void deleteContact() {// print available contacts and allow user to choose one of them and delete chosen contact and the related event (if exist)
        if (listC.empty()) {
            System.out.println("\nThe list is empty!\n");
            return;
        }

        int count = printNameAndPH();
        System.out.print("\nPlease choose the contact number:");
        int num = input.nextInt();
        input.nextLine();
        String temp = "";
        listC.findFirst();
        if (num > count || num < 1) {
            System.out.println("Sorry, you've entered an incorrect number.");
            return;
        } else if (num == 1) {
            temp = listC.retrieve().getName();
            listC.remove();
            System.out.println("\nThe contact was deleted successfully\n");
        } else {
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
        //to remove the event related to the contact
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

    public boolean isConflict(String date, String name, String title) {// Check if there's a date conflict
        if (listE.empty())
            return false;
        listE.findFirst();
        while (!listE.last()) {

            if ((listE.retrieve().getDate().equals(date) && listE.retrieve().getContactName().equals(name)) || (!listE.retrieve().getTitle().equals(title) && listE.retrieve().getDate().equals(date)))
                return true;
            listE.findNext();
        }
        return (listE.retrieve().getDate().equals(date) && listE.retrieve().getContactName().equals(name)) || (!listE.retrieve().getTitle().equals(title) && listE.retrieve().getDate().equals(date));

    }

    public void addEvent() {
        System.out.print("Enter event title:");
        String title = input.nextLine();
        System.out.print("Enter contact name:");
        String contactName = input.nextLine();
        System.out.print("Enter event date and time (MM/DD/YYYY HH:MM):");
        String date = input.nextLine();
        System.out.print("Enter event location:");
        String location = input.nextLine();
        listC.findFirst();
        while (!listC.last()) {
            if (listC.retrieve().equalsName(contactName) && !isConflict(date, contactName, title)) {// check if the contact exist
                Event temp = new Event(title, date, location, contactName);
                listE.insertSortedE(title, temp);
                System.out.println("\nThe event was added successfully.\n");
                return;
            }
            listC.findNext();
        }
        if (listC.retrieve().equalsName(contactName) && !isConflict(date, contactName, title)) {
            Event temp = new Event(title, date, location, contactName);
            listE.insert(temp);
            System.out.println("\nThe event was added successfully.");
            return;
        }
        if (isConflict(date, contactName, title))
            System.out.println("there is a conflict at that time");
        else
            System.out.println("\nThere's no contact exist with that name : \"" + contactName + "\" .\n");
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
    public void printSharedEventC(String contactName) {// print all events that share "contactName"
        listE.findFirst();
        int count = 0;
        System.out.println("\nThe contact name \"" + contactName + "\" event's are:");
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
    public void printSharedContactE(String eventTitle) {// print all events that share "contactName"
        listE.findFirst();
        int count = 0;
        System.out.println("\nThe event title \"" + eventTitle + "\" is shared with contacts:");
        while (!listE.last()) {
            if (listE.retrieve().getTitle().equals(eventTitle)) {
                System.out.println(++count + ". ");
                listC.searchContact(listE.retrieve().getContactName(), SearchType.name);
                listC.retrieve().printContact();
            }
            listE.findNext();
        }
        if (listE.retrieve().getTitle().equals(eventTitle)) {
            System.out.println(++count + ". ");
            listC.searchContact(listE.retrieve().getContactName(), SearchType.name);
            listC.retrieve().printContact();
        }
        if (count == 0)
            System.out.println("\nSorry, there's no event with that title : \"" + eventTitle + "\".\n");
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

    public void menu() {
        System.out.println();
        System.out.println("Please choose one of the following options:");
        System.out.println("1.Add a new contact.");
        System.out.println("2.Search for a contact.");
        System.out.println("3.Delete a contact.");
        System.out.println("4.Schedule an event.");
        System.out.println("5.Print event details.");
        System.out.println("6.Print contacts by first name.");
        System.out.println("7.Print all events alphabetically.");
        System.out.println("8.Exit\n");
    }

}
