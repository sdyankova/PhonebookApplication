import java.util.*;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class Main{
    public static void main(String[] args){

        Dictionary<String, Integer> phoneBook = new Hashtable<>();

        Scanner in = new Scanner(System.in);
        int option;
        do{
            printMenu();
            System.out.print("Enter your choice: ");
            option = in.nextInt();
            System.out.println();
            switch(option){
                case 1: printPhoneBook(phoneBook); break;
                case 2: addNewEntry(phoneBook); break;
                case 3: updateEntry(phoneBook); break;
                case 4: removeEntry(phoneBook); break;
                case 5: System.out.println("Goodbye"); break;
                default: System.out.println("Invalid option");
            }
            System.out.println();
        }
        while(option != 5);
    }

    public static void printMenu(){
        System.out.println("What would you like to do? ");
        System.out.println("1. Read the phone book");
        System.out.println("2. Add new entry");
        System.out.println("3. Update entry");
        System.out.println("4. Remove entry");
        System.out.println("5. Exit");
    }

    public static void printPhoneBook(Dictionary<String, Integer> phoneBook){
        int count = phoneBook.size();
        System.out.println("You have " + count + " contact" + ((1 == count)?"":"s"));
        Enumeration<String> keys = phoneBook.keys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            System.out.println("Name: " + key + ", Phone: " + phoneBook.get(key));
        }
    }

    public static void addNewEntry(Dictionary<String, Integer> phoneBook){
        addEditEntry(phoneBook);
        System.out.println("New entry added");
    }

    public static void updateEntry(Dictionary<String, Integer> phoneBook){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name to be updated: ");
        String name = in.nextLine();
        if (phoneBook.get(name) != null) {
            System.out.println("Please add updated information");
            addEditEntry(phoneBook);
            phoneBook.remove(name);
            System.out.println("Entry updated");
        } else {
            System.out.println("Entry not found");
        }
    }

    public static void addEditEntry(Dictionary<String, Integer> phoneBook){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = in.nextLine();
        System.out.print("Enter phone number: ");
        int phone = in.nextInt();

        phoneBook.put(name, phone);
    }

    public static void removeEntry(Dictionary<String, Integer> phoneBook){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = in.nextLine();
        if (phoneBook.get(name) != null) {
            phoneBook.remove(name);
            System.out.println("Entry removed");
        } else {
            System.out.println("Entry not found");
        }
    }

}
