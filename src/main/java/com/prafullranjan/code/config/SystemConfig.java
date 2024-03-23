package com.prafullranjan.code.config;

import com.prafullranjan.code.entity.Property;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SystemConfig
 *
 * @author Prafull
 */
@Configuration
public class SystemConfig {
    @Value("#{systemEnvironment['M2_HOME']}")
    private String value;

    @Bean
    public boolean setProperties(){
        Property.setM2Home(value);
        return true;
    }
}
