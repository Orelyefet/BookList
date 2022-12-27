package booklist;


import java.io.*;
import java.util.*;

/**
 * This class uses to implement all the functions required in the exercise
 */

public class BookList {
    private static String name;
    private static String phoneNumber;
    private static ArrayList<Contacts> myContacts = new ArrayList<Contacts>();
    private static Scanner scan = new Scanner(System.in);

    /**
     * Add new contact
     * This method implements adding a new contact
     * @return an indication if added a new contact has been succeeded or not
     */
    public boolean addContact() {
        System.out.print("Enter name: ");
        name = scan.nextLine();
        if (this.name == "") {
            System.out.println("This field can't be null!!");
            return false;
        }
        System.out.print("Enter phone number: ");
        phoneNumber = scan.nextLine();
        if (this.phoneNumber == "") {
            System.out.println("\nThis field can't be null!!");
            return false;
        }

        Contacts contacts = new Contacts(name, phoneNumber);
        myContacts.add(contacts);
        System.out.println("\nAdded contact has success\n");
        return true;
    }

    /**
     * Remove from the list the first duplicate that is detected by name
     * @return an indication if there were a contact that was removed from the list in case of duplicated records.
     */
    public boolean removeDupByName() {
        System.out.print("Enter name: ");
        name = scan.nextLine();
        for (int i = 0; i < myContacts.size(); i++) {
            for (int j = i + 1; j < myContacts.size(); j++) {
                if (myContacts.get(i).getName().equals(name)) {
                    if (myContacts.get(i).getName().equals(myContacts.get(j).getName())) {
                        myContacts.remove(myContacts.get(j));
                        System.out.println("The first duplicate that is detected has been removed");
                        return true;
                    }
                }
            }
        }
        System.out.println("There is no duplicated record to delete!!");
        return false;
    }

    /**
     * Printing all the existing contacts in the list
     */
    public void printBookList() {
        if (myContacts.size() > 0) {
            for (Contacts c : myContacts) {
                System.out.println(c.toString());
            }
        } else {
            System.out.println("You have not records on you book list!!");
        }
    }

    /**
     * Searching by name
     * This method uses a scanner input to search a record from the list.
     */
    public void searchByName() {
        System.out.print("Search by name: ");
        String exception = "";
        boolean isExist = false;

        if (myContacts.size() > 0) {
            this.name = scan.nextLine();
            for (Contacts c : myContacts) {
                if (name.equalsIgnoreCase(c.getName())) {
                    System.out.println(c.toString());
                    isExist = true;
                } else {
                    isExist = false;
                }
            }
            if(!(isExist)){
                System.out.println("\nThis name is not found on this list!!");
            }
        } else {
            System.out.println("You have not records on you book list!!");
        }
    }

    /**
     * Ascending sorting list by phone number
     * This method uses a comparator interface for comparing objects of the contacts class.
     */
    public void sortedListAcs() {
        if (myContacts.size() > 0) {
            Collections.sort(myContacts, new Comparator<Contacts>() {
                @Override
                public int compare(Contacts o1, Contacts o2) {
                    return o1.getPhoneNumber().compareTo(o2.getPhoneNumber());
                }
            });
            System.out.println("Your list is ordered in ascending list by phone");
        } else {
            System.out.println("You have not records to order");
        }
    }

    /**
     * Descending sorting list by contact name
     * This method uses a comparator interface for comparing objects of the contacts class.
     */
    public void sortedListDecs() {
        if (myContacts.size() > 0) {
            Collections.sort(myContacts, new Comparator<Contacts>() {
                @Override
                public int compare(Contacts o1, Contacts o2) {
                    return o2.getName().compareTo(o1.getName());
                }
            });
            System.out.println("Your list is ordered in descending list by name");
        } else {
            System.out.println("You have not records to order");
        }
    }

    /**
     * Reverse contact list
     * Printing the list of contacts in the original order.
     * Printing the list of contacts after the 'for' loop that uses to reverse order.
     */
    public void reverseList() {
        System.out.println("Before revers: ");
        printBookList();

        System.out.println("\nAfter Revers: ");
        for (int i = myContacts.size() - 1; i >= 0; i--) {
            System.out.println(myContacts.get(i));
        }
    }

    /**
     * Remove the records, where the name and the phone number are duplicated in the list.
     * @return an indication that the duplicate records that contain the same name and phone number both are removed from the list.
     */
    public boolean removeDupByNameAndPhone() {
        boolean isDupNameAndPhone = false;
        for (int i = 0; i < myContacts.size(); i++) {
            isDupNameAndPhone = true;
            for (int j = i + 1; j < myContacts.size(); j++) {
                if (myContacts.get(i).getName().equals(myContacts.get(j).getName())
                        && (myContacts.get(i).getPhoneNumber().equals(myContacts.get(j).getPhoneNumber()))) {
                    myContacts.remove(j);
                    j = j - 1;
                    System.out.println(myContacts.get(i).toString());
                } else if(isDupNameAndPhone = false){
                    System.out.println("There is no duplicated record to delete");
                    break;
                }
            }
        }
        System.out.println("\nYour duplicated records have has been removed");
        return true;
    }

    /**
     * Save a file as a csv file (for backup).
     * @throws FileNotFoundException
     */
    public void exportBackUp() throws FileNotFoundException {
        File backUp = new File("Backup.csv");
        PrintWriter out = new PrintWriter(backUp);

        for (Contacts c : myContacts) {
            out.println(c.toString());
        }
        out.close();
        System.out.println("Backup has been success");
    }

    public void loadFromExcelData(){
        ImportBackUp i = new ImportBackUp(myContacts);
        i.loadFromExcelData();

    }

}

