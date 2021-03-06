package com.addressmanagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        //HashMap will store the contact Details
        Map<String, Contacts> addressBook = new HashMap<String, Contacts>();
        System.out.println("Welcome To Address Book Program");
        //Creating one Object of Contact
        Scanner sc = new Scanner(System.in);
        int exit = 0;
        int choice;
        do {
            System.out.println("--------Welcome to Address Book---------");
            System.out.println("Enter '1' to Add contact");
            System.out.println("Enter '2' to Edit contact");
            System.out.println("Enter '3' to Delete contact");
            System.out.println("Enter '0' to Exit");
            //Try block  handles the input of the user
            try {
                choice = sc.nextInt();
            } catch (NumberFormatException e) {
                choice = -1;
            }
            if (choice != -1) {
                 menuChoice(addressBook, choice);
            }

        } while (choice != exit);
        System.out.println("Application terminating...");

    }
        public static void menuChoice(Map<String, Contacts> addressBook,int choice) {
            Scanner sc = new Scanner(System.in);
            Contacts contacts = new Contacts();
            switch (choice) {
                case 1:
                    contacts.addContact();
                    addressBook.put(contacts.getFirstName(), contacts);
                    break;
                case 2:
                    System.out.println("enter the first name which u want to edit");
                    String updat_name = sc.nextLine();
                    Contacts upDatedObj = search(updat_name, addressBook);
                    addressBook.remove(upDatedObj.getFirstName(),upDatedObj);
                    upDatedObj.addContact();
                    System.out.println("Searched contact"+upDatedObj + "First name:"+upDatedObj.getFirstName());
                    addressBook.put(upDatedObj.getFirstName(), upDatedObj);
                case 3:
                    System.out.println("enter the first name which u want to delete : ");
                    String dName = sc.nextLine();
                    addressBook.remove(dName);

            }
        }
    public static Contacts search(String searchByFirstName,Map<String, Contacts> mapVariable) {
        return mapVariable.get(searchByFirstName);
    }
}

