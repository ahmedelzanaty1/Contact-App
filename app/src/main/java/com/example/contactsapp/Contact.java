package com.example.contactsapp;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String phone;
    private String description;

    public Contact(String name, String phone, String description) {
        this.name = name;
        this.phone = phone;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }
}
