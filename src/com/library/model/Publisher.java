package com.library.model;

public class Publisher {

        private int publisher_id;
        private String publisher_name;
        private String address;
        private String phone;

    public Publisher(int publisher_id, String publisher_name, String address, String phone) {
        this.publisher_id = publisher_id;
        this.publisher_name = publisher_name;
        this.address = address;
        this.phone = phone;
    }

    public int getPublisher_id() {
        return publisher_id;
    }

    public void setPublisher_id(int publisher_id) {
        this.publisher_id = publisher_id;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

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

    @Override
    public String toString() {
        return "Publisher{" +
                "publisher_id=" + publisher_id +
                ", publisher_name='" + publisher_name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

