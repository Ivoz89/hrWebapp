package com.gft.service;

import com.gft.model.HumanResources;
import com.thoughtworks.xstream.XStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by iozi on 06/10/2015.
 */
@Service
public class XMLDao {

    @Autowired
    XStream xStream;

    @Autowired
    FileAccessService fileAccessService;

    public HumanResources loadHR() throws IOException {
        return (HumanResources) xStream.fromXML(fileAccessService.readStringFromFile());
    }

    public void saveHR(HumanResources humanResources) throws IOException {
        fileAccessService.writeStringToFile(xStream.toXML(humanResources));
    }
}
