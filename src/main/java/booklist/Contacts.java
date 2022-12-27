package booklist;

/**
 * This class uses to create a contact object
 */
public class Contacts {
    private String name;
    private String phoneNumber;

    public Contacts(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    @Override
    public String toString() {
        return "Contact Name: " + name +
                ", Phone Number: " + phoneNumber;
    }
}
