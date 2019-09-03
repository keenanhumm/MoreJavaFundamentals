package com.kaytec.threads;

import static com.kaytec.utils.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from my runnable");
    }
}
