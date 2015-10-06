package com.gft.util;

import com.gft.model.Employee;
import com.gft.model.HumanResources;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by iozi on 06/10/2015.
 */
public class RandomEmployeeFactory {

    public static HumanResources generateHR(int employeeCount) {
        final HumanResources humanResources = new HumanResources();
        final Random random = new Random();
        IntStream.range(0, employeeCount).forEach(i ->
                        humanResources.getEmployees().add(new Employee(
                                i,
                                RandomStringUtils.randomAlphabetic(10),
                                RandomStringUtils.randomAlphabetic(10),
                                new Date(),
                                RandomStringUtils.randomNumeric(10)
                        ))
        );
        return humanResources;
    }
}
