package com.gft.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iozi on 06/10/2015.
 */
public class HumanResources {

    private final List<Employee> employees;

    public HumanResources() {
        this.employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
