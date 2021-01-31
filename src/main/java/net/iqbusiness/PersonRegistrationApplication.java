package net.iqbusiness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("net.iqbusiness")
public class PersonRegistrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonRegistrationApplication.class, args);
    }

}
