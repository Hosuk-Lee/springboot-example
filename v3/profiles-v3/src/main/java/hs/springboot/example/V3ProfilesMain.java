package hs.springboot.example;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
@SpringBootApplication
public class V3ProfilesMain extends SpringBootServletInitializer {

    public static void main(String[] args) {

        Properties properties = System.getProperties();

//        properties.forEach((k, v) -> System.out.println("++ " + k + " : " + v));

        LinkedHashMap<String, String> collect = properties.entrySet().stream()
                .collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue()))
                .entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        collect.forEach((k, v) -> System.out.println(k + ":" + v));

        if (Objects.isNull(System.getProperties().getProperty("spring.profiles.active"))) {
            System.setProperty("spring.profiles.active", "local");
        }

        System.getProperties().entrySet().stream()
                .collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue()))
                .entrySet().stream().sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new))
                .forEach((k, v) -> System.out.println(k + ":" + v));
        SpringApplication.run(V3ProfilesMain.class, args);
    }


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        System.out.println("tq");
        servletContext.setInitParameter("spring.profiles.active", "test");
        System.out.println("tq");
        super.onStartup(servletContext);
        System.out.println("tq");
    }

    @Value("${app.name:noval}")
    String appProperty;

    @Bean
    public ApplicationRunner run1(ApplicationArguments args, ConfigurableEnvironment env) {
        log.info("debug,,, {}", env);
        env.setActiveProfiles("dev");
        log.info("debug,,, {}", env);
        return a -> {
            System.out.println(a);
        };
    }

//    @Bean
//    public ApplicationRunner run1(ApplicationArguments args,
//            Environment env) {
//        System.out.println("ApplicationRunner Args: " + Arrays.toString(args.getSourceArgs()));
//        return a -> {
//            System.out.println(env.getDefaultProfiles().length);
//            Arrays.stream(env.getDefaultProfiles()).forEach(System.out::println);
//
//            System.out.println(env.getActiveProfiles().length);
//            Arrays.stream(env.getActiveProfiles()).forEach(System.out::println);
//
//            System.out.println(env.getProperty("app.name") + ":" + appProperty);
//        };
//    }
}