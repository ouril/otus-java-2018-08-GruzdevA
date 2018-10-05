package ru.otus.gruzdev2;

import com.sun.management.GarbageCollectionNotificationInfo;

import javax.management.ListenerNotFoundException;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import javax.management.openmbean.CompositeData;
import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

class GCListener {

    private static int GC_THREAD_COUNT = 1;

    private final CountDownLatch doneSignal = new CountDownLatch(GC_THREAD_COUNT);
    private List<Runnable> registration = new ArrayList<>();

    private GCListener() {
        installGCObserver();
    }


    static void awaitGCDone() {
        GCListener gcl = new GCListener();
        try {
            System.gc();
            gcl.doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            gcl.registration.forEach(Runnable::run);
        }
    }

    private void installGCObserver() {
        List<GarbageCollectorMXBean> gcBeans = java.lang.management.ManagementFactory.getGarbageCollectorMXBeans();

        for (GarbageCollectorMXBean gcBean : gcBeans){
            System.out.println("GC name:" + gcBean.getName());

            NotificationEmitter emitter = (NotificationEmitter) gcBean;
            NotificationListener listener = (notification, o) -> {
                if (notification.getType().equals(GarbageCollectionNotificationInfo.GARBAGE_COLLECTION_NOTIFICATION)){

                    GarbageCollectionNotificationInfo info = GarbageCollectionNotificationInfo.from((CompositeData) notification.getUserData());

                    if (info.getGcCause().equals("System.gc()")) {
                        doneSignal.countDown();
                    }

                    System.out.println("Thread name: " + Thread.currentThread().getName());

                }
            };

            emitter.addNotificationListener(listener, null, null);

            registration.add(() -> {
                try {
                    emitter.removeNotificationListener(listener);
                } catch (ListenerNotFoundException e) {
                    e.printStackTrace();
                }
            });
        }


    }


}
