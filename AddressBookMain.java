package com.bl.addressbook;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author VAISHNAVI R. VISHWAKARMA.
 * @purpose: To implement Address Book System.
 * @DATE 27-SEP-2021.
 */
public class AddressBookMain {
    // main method
    public static void main(String[] args) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException, IOException {
        System.out.println("Welcome to Address Book System ! ");
        Scanner sc = new Scanner(System.in);
        Map<String, AddressBook> addressbookHashMap = new HashMap<String, AddressBook>();
        AddressBook addressBook = new AddressBook();
        // addressBook.getMenu();
        while (true) {
            System.out.println("\n--------------------------Welcome to Address Book System--------------------------");
            System.out.println("1. New Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Delete Address Book");
            System.out.println("4. Search by Option");
            System.out.println("5. View By Option");
            System.out.println("6. Count By Option");
            System.out.println("7. Write in A File");
            System.out.println("8. Read in A File");
            System.out.println("9. Write in A CSV File");
            System.out.println("10. Read in A CSV File");
            System.out.println("11. Exit");
            System.out.print("Enter Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Enter Name of new Address Book: ");
                    String bookName = sc.next();
                    sc.nextLine();
                    addressbookHashMap.put(bookName, addressBook);//adding bookname as a key and value is allocating memory for addressbook obj
                    addressBook.getMenu(addressbookHashMap.get(bookName));//call addressbookoption method with passing key of hashmap
                    break;
                case 2:
                    System.out.println("List of available Address Book : ");
                    Set keys = addressbookHashMap.keySet();//retrived keys from hashmap to show addressbooklist
                    Iterator i = keys.iterator();
                    while (i.hasNext()) {
                        System.out.println(i.next());
                    }
                    System.out.println("Enter Address Book name you want to Open : ");
                    String name = sc.nextLine();
                    System.out.println("Current Address Book is : " + name);
                    addressBook.getMenu(addressbookHashMap.get(name));//call method with passing address book name
                    break;
                case 3:
                    System.out.println("Enter Address Book name to be delete: ");
                    name = sc.nextLine();
                    addressbookHashMap.remove(name);//delete hashmap using remove fun
                    break;
                case 4:
                    addressBook.searchByOption();

                    break;
                case 5:
                    addressBook.veiwByOption(addressbookHashMap);
                    break;
                case 6:
                    addressBook.counByOption();

                    break;
                case 7:
                    AddressBookFileIO fileIO = new AddressBookFileIO();
                    fileIO.writeData(addressbookHashMap);
                    break;
                case 8:
                    AddressBookFileIO addressBookFileIO = new AddressBookFileIO();
                    addressBookFileIO.readData(addressbookHashMap);
                    break;
                case 9:
                    AddressBookCSV addressBookCSV = new AddressBookCSV();
                    addressBookCSV.writeDataToCSV();
                    break;
                case 10:
                    AddressBookCSV bookCSV = new AddressBookCSV();
                    bookCSV.readDataToCSV();
                    break;
                case 11:
                    sc.close();//for closing the programme
                    return;
                default:
                    System.out.println("You Entered Invalid Choice....!");
                    break;
            }
        }
    }
}