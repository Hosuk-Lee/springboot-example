package hs.springboot.example.schema;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hs.springboot.example.config.CustomBeanUtils;

public class Sample {

    private String message;

    public Sample(){
        message = "hello";
    }

    public void sayHello() throws JsonProcessingException {
        ObjectMapper om = (ObjectMapper) CustomBeanUtils.getBean(ObjectMapper.class);
        System.out.println(om.writeValueAsString(this));

    }

}
