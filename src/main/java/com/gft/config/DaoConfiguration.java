package com.gft.config;

import com.thoughtworks.xstream.XStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iozi on 06/10/2015.
 */
@Configuration
public class DaoConfiguration {

    @Bean
    public XStream xStream() {
        return new XStream();
    }
}
