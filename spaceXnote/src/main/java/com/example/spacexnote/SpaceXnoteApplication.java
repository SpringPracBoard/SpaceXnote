package com.example.spacexnote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpaceXnoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpaceXnoteApplication.class, args);
    }

}
