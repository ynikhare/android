package com.example.assignment;


import java.io.Serializable;

public class Person implements Serializable {

    private String name, title, address, phone, image, url;

    public Person(String name, String title, String address, String phone, String image, String url) {
        this.name = name;
        this.title = title;
        this.address = address;
        this.phone = phone;
        this.image = image;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {this.title = title; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

