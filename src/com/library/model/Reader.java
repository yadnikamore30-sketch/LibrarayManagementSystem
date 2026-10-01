package com.library.model;

public class Reader {
        private int reader_id;
        private String name;
        private String phone;
        private String email;
        private String address;

    public Reader(int reader_id, String name, String phone, String email, String address) {
        this.reader_id = reader_id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "reader_id=" + reader_id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

