package ru.otus.gruzdev2;

import java.util.function.Supplier;

class Benchmark {

    private final int size = 10_000_000;
    private Object[] array;


    Benchmark(){
        array = new Object[size];
    }


    void measureSafe(Supplier<Object> supplier, String name) {
        long memChangesSize = getMemSafe(()-> {
            fillingMemory(supplier);
        });

        System.out.println(name + " size:" + Math.round((double) memChangesSize / size));

    }

    private void fillingMemory(Supplier<Object> supplier) {
        int i = 0;
        while (i < size) {
            array[i] = supplier.get();
            i++;
        }
    }

    void measureSimple(Supplier<Object> supplier, String name) throws InterruptedException {
        long memBefore = simpleGetMemery();
        fillingMemory(supplier);
        long memAfter = simpleGetMemery();
        long memChangeSize = memAfter - memBefore;

        System.out.println(name + " size:" + Math.round((double) memChangeSize / size));
    }

    void clean() {
        array = new Object[size];
        GCListener.awaitGCDone();
    }

    private static long getMemSafe(Runnable create) {
        Runtime runtime = Runtime.getRuntime();
        GCListener.awaitGCDone();
        long memBefore = runtime.totalMemory() - runtime.freeMemory();
        create.run();
        GCListener.awaitGCDone();
        long memAfter = runtime.totalMemory() - runtime.freeMemory();
        return memAfter - memBefore;
    }

    private static long simpleGetMemery() throws InterruptedException {
        System.gc();
        Thread.sleep(10);
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();

    }


}
