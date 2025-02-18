package org.stefanini.backstefanini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class BackStefaniniApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackStefaniniApplication.class, args);
    }

}
