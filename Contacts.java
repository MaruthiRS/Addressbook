package com.bl.addressbook;

public class Contacts {
    // instance variable
    String firstName;
    String lastName;
    String city;
    String state;
    String pin;
    String mobileNo;
    String email;

    // Added default constructor for contact string
    public Contacts(String firstName, String lastName, String cityName,
                    String stateName, String pinNumber, String mobileNumber, String emailID) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.city = cityName;
        this.state = stateName;
        this.pin = pinNumber;
        this.mobileNo = mobileNumber;
        this.email = emailID;
    }

// generated getter setter method

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pin='" + pin + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}