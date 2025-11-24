package com.pivetta.cucumber.pessoa.config;

import com.pivetta.cucumber.CucumberApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = CucumberApplication.class)
public class CucumberSpringConfiguration {
}