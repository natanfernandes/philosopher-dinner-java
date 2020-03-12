package com.company;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Garfo {
    private static Random random = new Random();
    public Semaphore garfo = new Semaphore(1);
    public boolean take() {
        try {
            return garfo.tryAcquire(1, random.nextInt(400) + 100, TimeUnit.MILLISECONDS);
        } catch(InterruptedException e) {
            return false;
        }
    }

    public void putDown() {
        garfo.release();
    }
}
