package org.example.installer;

import org.example.Exception.ExceptionGenerate;
import org.example.annotation.Component;
import org.reflections.Reflections;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.stream.Collectors;

public class ComponentInstaller {
    public static HashMap<String, Object> objectHashMap = new HashMap<>();
    public static Reflections reflections;
    public static Set<Class<?>> classImpl = new HashSet<>();


    public static void processAnnotation(String packagePath) {
        reflections = new Reflections(packagePath);
        Set<Class<?>> classes=reflections.getTypesAnnotatedWith(Component.class);
        classImpl=classes.stream()
                .filter(cl->cl.getInterfaces().length>0)
                .collect(Collectors.toSet());
        for (Class<?> cl : classes) {
            if (!objectHashMap.containsKey(cl.getName())) {
                try {
                    Object obj = AutowiredInstaller.checkAnnotationAutowiredConstructor(cl);
                    AutowiredInstaller.checkAnnotationAutowiredMethod(obj);
                    AutowiredInstaller.checkAnnotationAutowiredField(obj);
                    objectHashMap.put(cl.getName(), obj);
                } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | ExceptionGenerate e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Object beanFactory(Class<?> classWitchNeedBean, Class<?> bean) {
        if (bean.isInterface()) {
            Class<?> finalBean = bean;
            List<Class<?>> classImplInter=classImpl.stream()
                    .filter(aClass -> Arrays.asList(aClass.getInterfaces()).contains(finalBean))
                    .toList();
            if(classImplInter.size() != 1){
                try {
                    throw new ExceptionGenerate("Interface dont have impl more that one class");
                } catch (ExceptionGenerate e) {
                    e.printStackTrace();
                }
            }
            bean=classImplInter.get(0);
        }
        if (!objectHashMap.containsKey(bean.getName())) {
            try {
                AutowiredInstaller.checkDeadLock(bean, classWitchNeedBean);
                Object obj = AutowiredInstaller.checkAnnotationAutowiredConstructor(bean);
                AutowiredInstaller.checkAnnotationAutowiredMethod(obj);
                AutowiredInstaller.checkAnnotationAutowiredField(obj);
                objectHashMap.put(bean.getName(), obj);
            } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException | ExceptionGenerate e) {
                e.printStackTrace();
            }
        }
        return objectHashMap.get(bean.getName());
    }
}
