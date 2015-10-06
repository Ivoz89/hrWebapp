package com.gft.rest;

import com.gft.model.Employee;
import com.gft.repository.DataAccessException;
import com.gft.repository.HRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by iozi on 06/10/2015.
 */
@RestController
public class EmployeeRestEndpoint {

    @Autowired
    HRRepository hrRepository;

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee get(@PathVariable int id) throws DataAccessException {
        return hrRepository.findById(id);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Employee> get(@RequestParam(value="tel", required=false) String tel)
            throws DataAccessException {
        if(tel != null) {
            return  hrRepository.findByTelephoneNumberPrefix(tel);
        }
        return hrRepository.findAll();
    }
}
