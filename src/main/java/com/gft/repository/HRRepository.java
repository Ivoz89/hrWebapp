package com.gft.repository;

import com.gft.model.Employee;

import java.io.IOException;
import java.util.List;

/**
 * Created by iozi on 06/10/2015.
 */
public interface HRRepository {

    List<Employee> findAll() throws DataAccessException;
    Employee findById(int id) throws DataAccessException;
    List<Employee> findByTelephoneNumberPrefix(String prefix) throws DataAccessException;
}
