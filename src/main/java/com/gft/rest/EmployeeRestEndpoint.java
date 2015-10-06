package com.gft.rest;

import com.gft.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by iozi on 06/10/2015.
 */
@RestController
public class EmployeeRestEndpoint {

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee get(@PathVariable int id) {
        return new Employee(1,"test","test", new Date());
    }
}
