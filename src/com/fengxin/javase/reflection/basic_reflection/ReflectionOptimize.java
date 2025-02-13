package com.fengxin.javase.reflection.basic_reflection;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author FENGXIN
 **/
@SuppressWarnings ("all")
public class ReflectionOptimize {
    public static void main (String[] args) throws Exception {
        Properties properties = new Properties ();
        properties.load (new FileInputStream ("src/com/fengxin/javase/reflection/basic_reflection/reflection.properties"));
        String className = properties.getProperty ("className");
        String methodName = properties.getProperty ("methodName");
        
        // 反射调用方法
        Class<?> cls = Class.forName (className);
        Object obj = cls.getDeclaredConstructor ().newInstance ();
        Method method = cls.getMethod (methodName);
        // 优化反射调用, 关闭权限检查
        method.setAccessible (true);
        long startTime = System.currentTimeMillis ();
        for (int i = 0; i < 999999999; i++) {
            method.invoke (obj);
        }
        long endTime = System.currentTimeMillis ();
        System.out.println ("反射调用方法耗时：" + (endTime - startTime) + "ms");
    }
}
