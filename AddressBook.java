package com.bl.addressbook;

import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    Contacts c;
    Scanner sc = new Scanner(System.in);
    static ArrayList<Contacts> contactList = new ArrayList<Contacts>();

    public static Map<String, Contacts> nameHashMap = new HashMap<String, Contacts>();
    public static Map<String, Contacts> cityHashMap = new HashMap<String, Contacts>();
    public static Map<String, Contacts> stateHashMap = new HashMap<String, Contacts>();

    public boolean checkContact(Contacts contact) {
        List<Contacts> checkByName = searchByName(contact.getFirstName());
        for (Contacts equalName : checkByName)
            if (equalName.equals(contact))
                return false;
        contactList.add(contact);
        nameHashMap.put(contact.getFirstName(), contact);
        cityHashMap.put(contact.getCity(), contact);
        stateHashMap.put(contact.getState(),contact);
        return true;
    }

    @Override
    public String toString() {
        if (contactList.isEmpty())
            return "No contacts found!";
        String result = new String();
        for (int i = 0; i < contactList.size(); i++) {
            result += " " + contactList.get(i);
        }
        return result;
    }

    public List<Contacts> searchByName(String name) {
        //stream and lambda for find filter given name from arraylist
        return contactList.stream().filter(person -> person.getFirstName().equalsIgnoreCase(name)).collect(Collectors.toList());

    }

    public List<Contacts> searchByCity(String city) {
        return contactList.stream().filter(person -> person.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
    }

    public List<Contacts> searchByState(String state) {
        return contactList.stream().filter(person -> person.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
    }

    public static void viewByName(Map<String, Contacts> nameHashMap) {
        nameHashMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "="+ e.getValue().toString()));
    }
    public static void viewByCity(Map<String, Contacts> cityHashMap) {
        cityHashMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "="+ e.getValue().toString()));
    }
    public static void viewByState(Map<String, Contacts> stateHashMap) {
        stateHashMap.entrySet().stream().forEach(e -> System.out.println(e.getKey() + "="+ e.getValue().toString()));
    }

    // Method to Add Contacts
    public static Contacts Add() {
        // c = new Contacts(firstName, LastName, cityName, statetName, pinNumber, mobileNumber, EmailID);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name : ");
        String firstName = sc.nextLine();

        System.out.println("Enter Last name : ");
        String LastName = sc.nextLine();

        System.out.println("Enter City name : ");
        String cityName = sc.nextLine();

        System.out.println("Enter State name : ");
        String stateName = sc.nextLine();

        System.out.println("Enter pin number : ");
        String pinNumber = sc.nextLine();

        System.out.println("Enter Mobile No : ");
        String mobileNumber = sc.nextLine();

        System.out.println("Enter Email ID : ");
        String EmailID = sc.nextLine();

        // To Set Details for Contacts
//        c.setFirstName(firstName);
//        c.setLastName(LastName);
//        c.setCity(cityName);
//        c.setState(statetName);
//        c.setPin(pinNumber);
//        c.setMobileNo(mobileNumber);
//        c.setEmail(EmailID);

        // used ArrayList to store
//        contactList.add(new Contacts(firstName, LastName, cityName,
//                stateName, pinNumber, mobileNumber, EmailID));
        return new Contacts(firstName, LastName, cityName,
                stateName, pinNumber, mobileNumber, EmailID);
    }

    // Method to Edit Contacts
    public void Edit() {
        System.out.println("Enter First Name of a Person to Edit:  ");
        String editName = sc.nextLine();

        if (contactList.isEmpty()) {
            System.out.println("Address Book is Empty! ");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                String name = contactList.get(i).getFirstName();
                if (editName.equalsIgnoreCase(name)) {
                    System.out.println("Enter first name : ");
                    String firstName = sc.next();
                    System.out.print("Enter New Last Name: ");
                    String lastName = sc.next();
                    System.out.print("Enter New City: ");
                    String city = sc.next();
                    System.out.print("Enter New State: ");
                    String state = sc.next();
                    System.out.print("Enter New Zip Code of area: ");
                    String zipCode = sc.next();
                    System.out.print("Enter New Mobile Number: ");
                    String mobileNo = sc.next();
                    System.out.print("Enter New Email Id: ");
                    String email = sc.next();

                    contactList.get(i).setFirstName(firstName);
                    contactList.get(i).setLastName(lastName);
                    contactList.get(i).setCity(city);
                    contactList.get(i).setState(state);
                    contactList.get(i).setPin(zipCode);
                    contactList.get(i).setMobileNo(mobileNo);
                    contactList.get(i).setEmail(email);
                    System.out.println("Contacts Updated! ");
                } else {
                    System.out.println("Name not Found!!");
                }
            }
            System.out.println(contactList);
        }
//        if (editName.equalsIgnoreCase(c.firstName)) {
//            Add();
//        } else {
//            System.out.println("Invalid First Name! ");
//            System.out.println("Please Enter Valid First Name: ");
//            Edit()
//        }
    }

    // method to delete contact
    public void Delete() {
        System.out.println("Enter First Name of a Person to Delete:  ");
        String deleteName = sc.nextLine();

        if (contactList.isEmpty()) {
            System.out.println("The AddressBook is Empty....!");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                String matcher = contactList.get(i).getFirstName();
                if (matcher.equalsIgnoreCase(deleteName)) {
                    contactList.remove(i);
                    System.out.println("Contact Deleted Successfully...");
                } else {
                    System.out.println("Name Not Found! ");
                }
            }
            System.out.println(contactList);

        }
    }

    public void showContact() {

        System.out.println("Number of Contacts Stored in " + contactList.size());
        if (contactList.isEmpty()) {
            System.out.println("There is No Contact Available");
        } else {
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println(contactList.get(i));
            }
        }
    }

    public void getMenu(AddressBook addressBook) {
        System.out.println("------------------Menu For AddressBooK------------------");

        boolean exit = false;
        do {
            System.out.println("Choose Option from below \n1. Add Contacts \n2. " +
                    "Edit Contact \n3. Delete Contact \n4. View Contacts \n5. Exit ");
            System.out.print("->:");
            int op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    if (addressBook.checkContact(Add()))
                        System.out.println("Contact Added Successfully....!");
                    else
                        System.out.println("Contact Already Exist....!");
                    break;
                //  Add();
//                    System.out.println("Contact added successfully....");
//                    if (addressBook.checkContact(Add())) {
//                        System.out.println("Contacts added Successfully!!");
//                    } else{
//                        System.out.println("Contact Already Exists!!");
//                    }
//                    break;
                case 2:
                    Edit();
                    System.out.println("Contact edited successfully....");
                    break;
                case 3:
                    Delete();
                    break;
                case 4:
                    showContact();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Please Choose Valid Option! ");
                    break;

            }
        } while (!exit);
    }

    public void searchByOption() {

        AddressBook addressBook = new AddressBook();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. By name");
        System.out.println("2. By city");
        System.out.println("3. By state");
        System.out.println("4. Back");
        System.out.println("Your choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter name: ");
                String name = sc.nextLine();
                contactList.forEach(book -> searchByName(name).forEach(System.out::println));
                break;
            case 2:
                System.out.println("Enter city: ");
                String city = sc.nextLine();
                contactList.forEach(book -> searchByCity(city).forEach(System.out::println));
                break;
            case 3:
                System.out.println("Enter state: ");
                String state = sc.nextLine();
                contactList.forEach(book -> searchByState(state).forEach(System.out::println));
                break;
            case 4:
                return;
            default:
                System.out.println("INVALID CHOICE!");

        }
    }

    /**
     *
     * @param addressbookHashMap
     */
    public void veiwByOption(Map<String, AddressBook> addressbookHashMap) {
        System.out.println("1. View By name");
        System.out.println("2. View By city");
        System.out.println("3. View By state");
        System.out.println("4. Back");
        System.out.print("Enter Your choice: ");
        int choice =sc.nextInt();
        sc.nextLine();
        switch (choice) {
            case 1:
                viewByName(nameHashMap);
                break;
            case 2:
                viewByCity(cityHashMap);
                break;
            case 3:
                viewByState(stateHashMap);
                break;
            case 4:
                return;
            default:
                System.out.println("INVALID CHOICE!");
        }
    }
    public void counByOption() {

        System.out.println("1. Count City ");
        System.out.println("2. Count State");
        System.out.println("3. Back ");
        System.out.println("Enter Your Choice : ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                Map<String, Long> countCity = contactList.stream().collect(Collectors.groupingBy(e -> e.getCity(),Collectors.counting()));
                System.out.println(countCity + "\n");
                break;
            case 2:
                Map<String, Long> countState = contactList.stream().collect(Collectors.groupingBy(e -> e.getState(),Collectors.counting()));
                System.out.println(countState + "\n");
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid Option");
        }
    }
}