package org.example.installer;

import org.example.Exception.ExceptionGenerate;
import org.example.annotation.Autowired;
import org.example.annotation.Value;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Stream;

public class AutowiredInstaller {
    public static Object checkAnnotationAutowiredConstructor(Class<?> cl) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ExceptionGenerate {
        Object[] parameterConstr;
        List<Constructor<?>> constructors = Stream.of(cl.getDeclaredConstructors())
                .filter(constructor -> constructor.isAnnotationPresent(Autowired.class))
                .toList();
        if (constructors.size() > 1) {
            throw new ExceptionGenerate("Dont possible create class witch have more that one constructor "+cl.getName());
        } else {
            if (constructors.size() == 1) {
                parameterConstr = Stream.of(constructors.get(0).getParameterTypes())
                        .map(parameter -> ComponentInstaller.beanFactory(cl, parameter))
                        .toArray();
                return constructors.get(0).newInstance(parameterConstr);
            }
        }
        return cl.getConstructor().newInstance();
    }


    public static void checkAnnotationAutowiredField(Object bean) throws IllegalAccessException, ClassNotFoundException {
        if (Stream.of(bean.getClass().getDeclaredFields()).anyMatch(field -> field.isAnnotationPresent(Value.class))) {
            ValueInstaller.processAnnotation(bean);
        }
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.getAnnotation(Autowired.class) != null) {
                field.setAccessible(true);
                field.set(bean, ComponentInstaller.beanFactory(bean.getClass(), field.getType()));
            }
        }
    }

    public static void checkAnnotationAutowiredMethod(Object bean) throws InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        Object[] parametersMethod;
        for (Method method : bean.getClass().getDeclaredMethods()) {
            if (method.getAnnotation(Autowired.class) != null) {
                parametersMethod = Stream.of(method.getParameterTypes())
                        .map(parameter -> ComponentInstaller.beanFactory(bean.getClass(), parameter))
                        .toArray();
                method.invoke(bean, parametersMethod);
            }
        }
    }

    public static void checkDeadLock(Class<?> bean, Class<?> classWitchNeedBean) throws ExceptionGenerate {
        for (Constructor<?> constructor : bean.getConstructors()) {
            if (constructor.getAnnotation(Autowired.class) != null)
                for (Class<?> parameter : constructor.getParameterTypes()) {
                    if (parameter.getName().equals(classWitchNeedBean.getName())) {
                        throw new ExceptionGenerate("Detected deadLock"+classWitchNeedBean.getName()+"with"+ bean.getName());
                    }
                }
        }
    }
}
