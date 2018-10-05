package ru.otus.gruzdev2;

import java.lang.management.ManagementFactory;

public class Main {

    public static void main(String... args) throws InterruptedException {

        System.out.println("PID  " + ManagementFactory.getRuntimeMXBean().getName());

        Benchmark benchmark = new Benchmark();

        benchmark.measureSafe(Object::new, "Object");
        benchmark.clean();
        benchmark.measureSimple(Object::new, "Object");
        benchmark.clean();

        benchmark.measureSafe(String::new, "String");
        benchmark.clean();
        benchmark.measureSimple(String::new, "String");
        benchmark.clean();

        benchmark.measureSafe(() -> new String(new char[0]), "String");
        benchmark.clean();
        benchmark.measureSimple(() -> new String(new char[0]), "String");
        benchmark.clean();

        benchmark.measureSafe(() -> new String(new char[10]), "String");
        benchmark.clean();
        benchmark.measureSimple(() -> new String(new char[10]), "String");
        benchmark.clean();



    }

}
