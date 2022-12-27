package booklist;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MobilePhone {

    /**
     * This method contains a switch case that uses to invoke the functions from a BookList class.
     * Using a scanner input to choose the option/function.
     *
     * @param ar1gs
     * @return
     * @throws IOException
     */

    public void mobilePhone () throws FileNotFoundException {
        BookList b1 = new BookList();

        boolean quit = false;

        while (!(quit)) {
            menu();
            System.out.print("\nChoose your wanted option: ");

            switch (input()) {
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
                    quit = true;
                    System.out.println("End");
                    break;
                default:
                    System.out.println("\nSorry, your chosen option is invalid.");
                    break;
            }
        }
    }

    /**
     * This method uses for printing the options list.
     */
    private static void menu () {
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
                + "11.Exit");
    }

    /**
     * This method return int values, and handle invalid entered chars.
     */
    private static int input () {
        Scanner scan = new Scanner(System.in);

        boolean validIntegerEntered = false;
        int options = 0;
        while (!(validIntegerEntered)) {
            try {
                options = scan.nextInt();
                validIntegerEntered = true;
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.print("Enter a valid value: ");
            }
        }
        return options;
    }
}
