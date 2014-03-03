package com.myblog.flexjson;

import java.util.Date;
import java.util.List;

import flexjson.JSON;

public class Person {

    private String name;
    private Date birthday;
    private String nickname;
    private List<Address> addresses;
    private List<Phone> phoneNumbers;

    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Person(String name, Date birthday, String nickname) {
        super();
        this.name = name;
        this.birthday = birthday;
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @JSON
    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @JSON
    public List<Phone> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<Phone> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", birthday=" + birthday
                + ", nickname=" + nickname + "]";
    }

}
