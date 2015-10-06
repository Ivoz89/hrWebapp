package com.gft.repository;

import com.gft.model.Employee;
import com.gft.service.XMLDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by iozi on 06/10/2015.
 */
@Repository
public class XMLHRRepository implements HRRepository {

    public static final String UNABLE_TO_ACCESS_DATA = "Unable to access data";

    @Autowired
    XMLDao xmlDao;

    @Override
    public List<Employee> findAll() throws DataAccessException {
        try {
            return xmlDao.loadHR().getEmployees();
        } catch (IOException e) {
            throw new DataAccessException(UNABLE_TO_ACCESS_DATA,e);
        }
    }

    @Override
    public Employee findById(int id) throws DataAccessException {
        try {
            return xmlDao.loadHR().getEmployees().stream()
                    .filter(e -> e.getId() == id)
                    .findFirst()
                    .get();
        } catch (IOException e) {
            throw new DataAccessException(UNABLE_TO_ACCESS_DATA,e);
        }
    }

    @Override
    public List<Employee> findByTelephoneNumberPrefix(String prefix) throws DataAccessException {
        try {
            return xmlDao.loadHR().getEmployees().stream()
                    .filter(e -> e.getTelephoneNumber().startsWith(prefix))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new DataAccessException(UNABLE_TO_ACCESS_DATA,e);
        }
    }
}
