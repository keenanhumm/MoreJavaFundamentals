package com.kaytec.threads;

import static com.kaytec.threads.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "hello from the main thread");
        Thread anotherThread = new AnotherThread();
        anotherThread.setName("=====AnotherName====");
        anotherThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hey there from the anonymous class");
            }
        }.start();

        Thread myRunnable = new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED + "hello from anon. class implementation of run");
                try {
                    anotherThread.join();
                    System.out.println(ANSI_RED + anotherThread.getName() + " terminated, i'm running again.");
                } catch(InterruptedException e) {
                    System.out.println(ANSI_RED + "i cant wait for that guy. I was interrupted!");
                }
            }
        });
        myRunnable.start();
        anotherThread.interrupt();

        System.out.println(ANSI_PURPLE + "hello no 2 from main thread");
    }
}
