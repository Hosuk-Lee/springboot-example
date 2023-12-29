package hs.springboot.example.config;

import org.springframework.context.ApplicationContext;

public class CustomBeanUtils {

    public static Object getBean(Class<?> classType) {
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();
        System.out.println(applicationContext);
        return applicationContext.getBean(classType);
    }

}
