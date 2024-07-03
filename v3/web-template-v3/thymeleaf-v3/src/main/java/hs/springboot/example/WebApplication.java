package hs.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @GetMapping("/aaa")
    public String aaa() throws InterruptedException {
        System.out.println("Request aaa");
        Thread.sleep(5000);
        return "/index.html";
    }


    @GetMapping("/bbb")
    public String bbb() {
        System.out.println("Request bbb");
        return "/static.html";
    }

    @GetMapping("/sample")
    public String sample() {
        System.out.println("sample template");
        return "sample/sample";
    }
}