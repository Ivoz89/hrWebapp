package com.gft.service;

import com.google.common.io.Files;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by iozi on 06/10/2015.
 */
@Service
public class FileAccessService {


    @Value("${data.xml.path}")
    String xmlFilePath;

    public void writeStringToFile(String content) throws FileNotFoundException, IOException {
        try (BufferedWriter writer = Files.newWriter(new File(xmlFilePath), Charset.forName("UTF-8"))) {
            writer.append(content);
        }
    }

    public String readStringFromFile() throws IOException {
        return Files.toString(new File(xmlFilePath), Charset.forName("UTF-8"));
    }

}
