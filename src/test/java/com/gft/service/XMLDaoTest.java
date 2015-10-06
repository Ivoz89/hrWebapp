package com.gft.service;

import com.gft.config.Application;
import com.gft.util.RandomEmployeeFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

import static junit.framework.TestCase.fail;

/**
 * Created by iozi on 06/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = Application.class)
public class XMLDaoTest {

    @Autowired
    XMLDao xmlDao;

    @Test
    public void testSavingToXML() {
        try {
            xmlDao.saveHR(RandomEmployeeFactory.generateHR(10));
        } catch (IOException e) {
            e.printStackTrace();
            fail();
        }
    }


}