package com.gft.model;

import java.util.Date;

/**
 * Created by iozi on 06/10/2015.
 */
public class Employee {

    private int id;
    private String name;
    private String surname;
    private Date dob;
    private String telephoneNumber;

    private Employee() {
    }

    public Employee(int id, String name, String surname, Date dob, String telephoneNumber) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
        this.telephoneNumber = telephoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getDob() {
        return dob;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }
}
