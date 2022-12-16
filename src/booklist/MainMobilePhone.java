package booklist;

import java.io.IOException;
import java.util.Scanner;

public class MainMobilePhone {

    public static void main(String[] ar1gs) throws IOException {

        Scanner scan = new Scanner(System.in);
        BookList b1 = new BookList();

        boolean quit = false;
        menu();
        while (!(quit)) {
            System.out.print("\nChoose your wanted option: ");
            int options = scan.nextInt();
            switch (options) {
                case 1:
                    b1.addContact();
                    break;
                case 2:
                    b1.removeDupByName();
                    break;
                case 3:
                    b1.printBookList();
                    break;
                case 4:
                    b1.searchByName();
                    break;
                case 5:
                    b1.sortedListAcs();
                    break;
                case 6:
                    b1.sortedListDecs();
                    break;
                case 7:
                    b1.reverseList();
                    break;
                case 8:
                    b1.removeDupByNameAndPhone();
                    break;
                case 9:
                    b1.exportBackUp();
                    break;
                case 10:
                    b1.loadFromExcelData();
                    break;
                case 11:
                    menu();
                    break;
                case 12:
                    quit = true;
                    System.out.println("End");
                    break;
                default:
                    System.out.println("Sorry, your chosen option is invalid.");
            }

        }
    }
    private static void menu (){
        System.out.println("\n1. Add new contact\n"
                        + "2. Remove duplicate contact\n"
                        + "3. Print all existing contacts from the list\n"
                        + "4. Search by name, and view all the records from the list\n"
                        + "5. Order by phone number ascending\n"
                        + "6. Order by phone number descending\n"
                        + "7. Reverse list\n"
                        + "8. Remove duplicate records where the name and phone number already exist\n"
                        + "9. Backup your booklist in a csv file\n"
                        + "10.Import your list from a file to your booklist\n"
                        + "11.Main manu\n"
                        + "12.Exit");
    }
}

