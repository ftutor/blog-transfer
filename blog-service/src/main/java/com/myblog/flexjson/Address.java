package com.myblog.flexjson;

public class Address {

    private String name;
    private String street;
    private String city;
    private String state;
    private Zipcode zipcode;

    public Address() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Address(String name, String street, String city, String state) {
        super();
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public Zipcode getZipcode() {
        return zipcode;
    }

    public void setZipcode(Zipcode zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address [name=" + name + ", street=" + street + ", city="
                + city + ", state=" + state + ", zipcode=" + zipcode + "]";
    }

}
