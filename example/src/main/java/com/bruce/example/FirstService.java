package com.bruce.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties")
public class FirstService {
    private final FirstClass firstClass;
    @Value("${my.custom.property}")
    public String customProperty;

    @Value("${my.prop}")
    public String customPropertyFromAnotherFile;

    @Value("${my.custom.property.int}")
    public String customPropertyInt;

    public FirstService(@Qualifier("secondBean") FirstClass firstClass){
        this.firstClass = firstClass;
    }

    public String tellStory(){
        return "The dependency is saying: " + firstClass.sayHello();
    }

    public String getCustomProperty() {
        return customProperty;
    }

    public String getCustomPropertyFromAnotherFile() {
        return customPropertyFromAnotherFile;
    }

    public String getCustomPropertyInt() {
        return customPropertyInt;
    }
}
