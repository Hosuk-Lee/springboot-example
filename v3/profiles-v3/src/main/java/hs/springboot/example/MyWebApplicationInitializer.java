package hs.springboot.example;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

@Slf4j
@Configuration
public class MyWebApplicationInitializer
        implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        System.out.println(123);
        log.info("123");
        servletContext.setInitParameter(
                "spring.profiles.active", "dev");
    }
}