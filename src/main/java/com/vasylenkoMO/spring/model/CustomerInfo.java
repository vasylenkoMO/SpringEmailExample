package com.vasylenkoMO.spring.model;

/**
 * Created by vastl271nko on 19.08.16.
 */
public class CustomerInfo {

    private String name;

    private String address;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomerInfo [name=" + name + ", address=" + address + ", email=" + email + "]";
    }
}
