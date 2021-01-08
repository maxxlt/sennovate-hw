package com.sennovate.models;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
public class Client {
    @Id
    private long id;
    private String fname, lname, address, city, state, email, work;
    private int zip;
    private double salary;

    public Client(long id, String fname, String lname, String email) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
    }
}
