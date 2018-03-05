package com.ncpaw.view;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

/**
 * 
 * @author santiagobernal
 *
 */
@SpringBootConfiguration
public class Config {
	
	 @Bean
	 @Primary
	 public MappingJackson2XmlHttpMessageConverter mappingJackson2XmlHttpMessageConverter(
	         Jackson2ObjectMapperBuilder builder) {
	     ObjectMapper mapper = builder.createXmlMapper(true).build();
	     ((XmlMapper) mapper).enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION);
	     return new MappingJackson2XmlHttpMessageConverter(mapper);
	 }

 	 
}
