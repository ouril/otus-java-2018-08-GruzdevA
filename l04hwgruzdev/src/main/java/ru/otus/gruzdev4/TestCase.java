package ru.otus.gruzdev4;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TestCase {

    @Test
    public void test(){
        System.out.println("Hello");
    }

    void runTests () {
        Class<? extends  Object> cls = this.getClass();
        Method[] methods = cls.getDeclaredMethods();

        Arrays.stream(methods).forEach((method) -> {
            String name = method.getName();
            method.setAccessible(true);
            Annotation[] anatatins = method.getDeclaredAnnotations();
            Arrays.stream(anatatins).forEach(anatation -> {
                System.out.println(anatation instanceof Test);
                Test test = (Test) anatation;
                System.out.println(test.skip());
            });
        });
        
        System.out.println(Arrays.toString(methods));

    }
}
