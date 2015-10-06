package com.gft.model;

import java.util.Currency;
import java.util.Date;

/**
 * Created by iozi on 06/10/2015.
 */
public class Employee {

    private final int id;
    private final String name;
    private final String surname;
    private final Date dob;
    private String telephoneNumber;
    private Currency salary;

    public Employee(int id, String name, String surname, Date dob) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dob = dob;
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

    public Currency getSalary() {
        return salary;
    }

    public void setSalary(Currency salary) {
        this.salary = salary;
    }


}
