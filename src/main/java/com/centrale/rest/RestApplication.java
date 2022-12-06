package com.centrale.rest;

import com.centrale.rest.repository.PersonRepository;
import com.centrale.rest.entity.PersonEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;


@SpringBootApplication
public class RestApplication {

    private static final Logger log = LoggerFactory.getLogger(RestApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    // Simply to execute some code after startup
    @Bean
    public CommandLineRunner demo(PersonRepository personRepository) {
        return (args) -> {
            log.info("Create and save school class");



            PersonEntity personEntity = new PersonEntity();
            personEntity.setName("John");
            personEntity.setPassword("colocation");




            personRepository.save(personEntity);




        };
    }


}
