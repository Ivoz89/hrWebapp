package com.gft.repository;

import com.gft.model.Employee;

import java.util.List;

/**
 * Created by iozi on 06/10/2015.
 */
public interface HRRepository {

    List<Employee> findAll();
    Employee findById(int id);
    List<Employee> findByTelephoneNumberPrefix(String prefix);
}
