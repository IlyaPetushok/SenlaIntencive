package org.example.installer;

import org.example.annotation.Value;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;


public class ValueInstaller {
    public static void processAnnotation(Object obj){
        Properties properties=new Properties();
        for (Field field : obj.getClass().getDeclaredFields()) {
            Value annotation=field.getAnnotation(Value.class);
            if(annotation!=null){
                String path= annotation.pathProperty();
                String value= annotation.value();
                try {
                    properties.load(new FileInputStream(path));
                    field.setAccessible(true);
                    field.set(obj,properties.getProperty(value));
                }  catch (IOException | IllegalAccessException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }
}
