package hs.springboot.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class TemplateController {

    public record Person(String name, String address) {

    }

    @GetMapping("/template")
    public String template(Model model) {
        log.info("Request template");
        Person person = new Person("Lee", "Seoul");
        model.addAttribute("person", person);
        return "template"; // template.html
    }

    @GetMapping("/person")
    public String personInquiry(Model model) {
        log.info("person inquiry");
        Person person = new Person("Lee", "Seoul");
        model.addAttribute("person", person);
        return "sample/person_inquiry"; //
    }

}
