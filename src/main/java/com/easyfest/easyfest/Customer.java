package com.easyfest.easyfest;/*@author:Dilshan Rajika Withanachchi*/

public class Customer {
    private String id;
    private String name;
    private String dob;
    private String address;
    private String city;

    //create Constructor full args and no args press Alt+Insert


    public Customer(String id, String name, String dob, String address, String city) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.city = city;
    }

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    //create Encapsulate bean using this attribute press Ctrl+Shift+Alt+t

}
