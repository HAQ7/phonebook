//CLASS: Contact.java
//        CSC212 Data structures - Project phase I
//        Fall 2023
//        EDIT DATE:
//        10-16-2023
//        TEAM:
//        HHM
//        AUTHORS:
//        Hussam Qannam (ID443100831) , Hisham Alsuhaibani (ID443100662) , Mohammed Al Mahmud (ID443101240)

public class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String birthday;
    private String notes;

    public Contact(String name, String phoneNumber, String email, String address, String birthDay, String notes) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.birthday = birthDay;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNotes() {
        return notes;
    }

    public boolean equalsName(String name) {
        return this.name.equals(name);
    }

    public boolean equalsPhoneNumber(String phoneNumber) {
        return this.phoneNumber.equals(phoneNumber);
    }

    public boolean equalsEmail(String email) {
        return this.email.equals(email);
    }

    public boolean equalsAddress(String address) {
        return this.address.equals(address);
    }

    public boolean equalsBirthday(String birthday) {
        return this.birthday.equals(birthday);
    }


    public void printContact() {//print all contact attribute
        System.out.println("\n**************");
        System.out.println("Name:" + name);
        System.out.println("Phone Number:" + phoneNumber);
        System.out.println("Email Address:" + email);
        System.out.println("Address:" + address);
        System.out.println("Birthday:" + birthday);
        System.out.println("Notes:" + notes);
        System.out.println("**************\n");
    }
}
