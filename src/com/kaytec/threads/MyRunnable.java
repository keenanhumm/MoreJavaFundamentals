package com.kaytec.threads;

import static com.kaytec.threads.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from my runnable");
    }
}
