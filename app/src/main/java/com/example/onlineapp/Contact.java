package com.example.onlineapp;



// ekhane joto gulo parameter ase segula niye ekta constructor banate hobe .

public class Contact {

    String name;
    String email;
    String contact;
    String password;



    public Contact(String name, String email, String contact, String password){

        this.setName(name);
        this.setEmail(email);
        this.setContact(contact);
        this.setPassword(password);
    }

    // erpor alter insert chepe getter setter method banate hobe

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getPassword() {
        return password;
    }
}
