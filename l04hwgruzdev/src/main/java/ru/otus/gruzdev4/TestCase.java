package ru.otus.gruzdev4;

import java.util.Arrays;

public class TestCase {

    @Test
    public void test(){
        System.out.println("Hello");
    }

    void runTests () {
        Class<? extends  Object> cls = this.getClass();
        Object[] methods = cls.getMethods();
        
        System.out.println(Arrays.toString(methods));

    }
}
