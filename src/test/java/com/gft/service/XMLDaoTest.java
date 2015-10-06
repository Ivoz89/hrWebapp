package com.gft.service;

import com.gft.config.Application;
import com.gft.config.DaoConfiguration;
import com.gft.model.HumanResources;
import com.gft.util.RandomEmployeeFactory;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.fail;

/**
 * Created by iozi on 06/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DaoConfiguration.class, XMLDao.class, FileAccessService.class})
public class XMLDaoTest {

    public static final int EMPLOYEE_COUNT = 10000;
    @Autowired
    XMLDao xmlDao;

    @Test
    public void testSavingAndLoadingToXML() {
        try {
            xmlDao.saveHR(RandomEmployeeFactory.generateHR(EMPLOYEE_COUNT));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
        try {
            HumanResources hr = xmlDao.loadHR();
            assertNotNull(hr);
            assertEquals(EMPLOYEE_COUNT, hr.getEmployees().size());
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }
}