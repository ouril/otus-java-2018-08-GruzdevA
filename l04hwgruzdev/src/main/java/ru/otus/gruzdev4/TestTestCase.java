package ru.otus.gruzdev4;

public class TestTestCase extends TestCase {

    @Before
    public void print(){
        System.out.println("Hello from before");
    }

    @Test
    public void test1(){
        assertEqual("test1", 1 == 2);
    }

    @Test
    public void test2(){
        assertEqual("test2", 1 == 1);
    }
}
