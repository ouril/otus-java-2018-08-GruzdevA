package ru.otus.gruzdev4;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class TestCase {
    ArrayList<Method> testMethods = new ArrayList<>();
    ArrayList<Method> beforMethods = new ArrayList<>();
    ArrayList<Method> afterMethods = new ArrayList<>();

    @Test
    public void test(){
        System.out.println("Hello");
    }

    void getTests () {
        Class<? extends  Object> cls = this.getClass();
        Method[] methods = cls.getDeclaredMethods();


        Arrays.stream(methods).forEach((method) -> {
            String methodName = method.getName();
            System.out.println("Name of method  ->  " + methodName);
            method.setAccessible(true);
            Annotation[] anatatins = method.getDeclaredAnnotations();
            Arrays.stream(anatatins).forEach(anatation -> {
                if(anatation instanceof Test && !((Test) anatation).skip()){
                   testMethods.add(method);
                }
            });
        });
    }

    void runTests(){
        getTests();
        runTypeofMethods(testMethods);
    }

    private void runTypeofMethods(ArrayList<Method> methods) {
        if (!methods.isEmpty()) {
            methods.forEach((method) -> {
                try {
                    method.invoke(this);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
