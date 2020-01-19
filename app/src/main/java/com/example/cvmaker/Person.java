package com.example.cvmaker;

public class Person {
    String firstNameS, lastNameS, emailAddressS, passwordS;

    public Person() {
    }

    public Person(String firstNameS, String lastNameS, String emailAddressS, String passwordS) {
        this.firstNameS = firstNameS;
        this.lastNameS = lastNameS;
        this.emailAddressS = emailAddressS;
        this.passwordS = passwordS;
    }

    public String getFirstNameS() {
        return firstNameS;
    }

    public void setFirstNameS(String firstNameS) {
        this.firstNameS = firstNameS;
    }

    public String getLastNameS() {
        return lastNameS;
    }

    public void setLastNameS(String lastNameS) {
        this.lastNameS = lastNameS;
    }

    public String getEmailAddressS() {
        return emailAddressS;
    }

    public void setEmailAddressS(String emailAddressS) {
        this.emailAddressS = emailAddressS;
    }

    public String getPasswordS() {
        return passwordS;
    }

    public void setPasswordS(String passwordS) {
        this.passwordS = passwordS;
    }
}
