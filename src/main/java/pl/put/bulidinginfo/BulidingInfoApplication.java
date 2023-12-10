package pl.put.bulidinginfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class BulidingInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BulidingInfoApplication.class, args);
    }

}
