package com.myblog.flexjson;

public class Phone {

    private String name;
    private String number;

    public Phone() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Phone(String name, String number) {
        super();
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
