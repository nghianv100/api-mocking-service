package mocking.service;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class})
public class MockingApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MockingApiServiceApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
