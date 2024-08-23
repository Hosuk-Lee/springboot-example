package hs.springboot.example.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class APMMain {

    public static void main(String[] args) {
//        ElasticApmAttacher.attach();
        SpringApplication.run(APMMain.class,args);
    }

}