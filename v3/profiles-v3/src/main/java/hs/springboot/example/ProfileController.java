package hs.springboot.example;

import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${app.name}")
    private String projectName;
    @Autowired
    Environment environment;

    @GetMapping("/api/profile")
    public Map<String, Object> inquiry() {
        System.out.println(projectName);
        System.out.println(environment.getProperty("app.name"));
        System.out.println(Arrays.toString(environment.getActiveProfiles()));
        System.out.println(Arrays.toString(environment.getDefaultProfiles()));

        System.out.println(System.getProperties());

        return null;
    }
}
