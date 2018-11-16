package ru.otus.gruzdev4;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class TestCase {
    private ArrayList<Method> testMethods = new ArrayList<>();
    private ArrayList<Method> beforMethods = new ArrayList<>();
    private ArrayList<Method> afterMethods = new ArrayList<>();
    private int failed = 0;
    private int isOk = 0;


    public void assertEqual(String testName, boolean result){
        if (result) {
            System.out.println(testName + " -> ok");
            isOk++;
        } else {
            System.out.println(testName + " -> failed");
            failed++;
        }
    }

    private void getTests() {
        Class<? extends Object> cls = this.getClass();
        Method[] methods = cls.getDeclaredMethods();


        Arrays.stream(methods).forEach((method) -> {
            method.setAccessible(true);
            Annotation[] annotations = method.getDeclaredAnnotations();
            Arrays.stream(annotations).forEach(annotation -> {
                if (annotation instanceof Test && !((Test) annotation).skip()) {
                    testMethods.add(method);
                } else if (annotation instanceof Before) {
                    beforMethods.add(method);
                } else if (annotation instanceof  After) {
                    afterMethods.add(method);
                }
            });
        });
    }

    public void runTests(){
        getTests();
        runTypeofMethods(beforMethods);
        runTypeofMethods(testMethods);
        runTypeofMethods(afterMethods);
        System.out.println("There is " + isOk + " test was OK" + " and " + failed + " was failed");
    }

    private void runTypeofMethods(ArrayList<Method> methods) {

        if (!methods.isEmpty()) {
            for (Method method : methods) {

                    try{
                        method.invoke(this);
                    } catch (IllegalAccessException | InvocationTargetException e){
                        e.printStackTrace();
                    }



            }
        }

    }
}
