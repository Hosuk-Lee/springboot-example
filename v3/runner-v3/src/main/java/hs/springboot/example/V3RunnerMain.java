package hs.springboot.example;

import hs.springboot.example.schema.Sample;
import hs.springboot.example.service.SayHello;
import java.util.Arrays;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class V3RunnerMain {

    public static void main(String[] args) {
            SpringApplication.run(V3RunnerMain.class, args);
    }

    @Bean
    public ApplicationRunner run1(ApplicationArguments args,
            SayHello sayHello){
        System.out.println("ApplicationRunner Args: " + Arrays.toString(args.getSourceArgs()));
        return a -> {
            System.out.println("!@#");
            new Sample().sayHello();
            sayHello.excute();
        };
    }


}