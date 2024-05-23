package hs.springboot.example;

import hs.springboot.example.schema.Sample;
import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

public class Main{

    public static void main(String[] args) {
            SpringApplication.run(Main.class, args);
    }

    @Bean
    public ApplicationRunner run1(ApplicationArguments args){
        System.out.println("ApplicationRunner Args: " + Arrays.toString(args.getSourceArgs()));
        return a -> {
            System.out.println("!@#");
            new Sample().sayHello();
        };
    }


}