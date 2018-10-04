package ru.otus.gruzdev2;

import java.lang.management.ManagementFactory;

public class Main {

    public static void main(String... args) throws InterruptedException {

        System.out.println("PID  " + ManagementFactory.getRuntimeMXBean().getName());



    }


    private static long getMemery() throws InterruptedException {
        System.gc();
        Thread.sleep(10);
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();

    }
}
