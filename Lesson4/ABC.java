package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class ABC {
    private char print = 'A';

    public static void main(String[] args) {
        ABC abc = new ABC();
        Thread thread1 = new Thread(() -> abc.classA());
        Thread thread2 = new Thread(() -> abc.classB());
        Thread thread3 = new Thread(() -> abc.classC());
        thread1.start();
        thread2.start();
        thread3.start();

    }

    public synchronized void classA() {
        for (int i = 0; i < 5; i++) {
            while (print != 'A') {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A");
            print = 'B';
            notifyAll();
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void classB() {
        for (int i = 0; i < 5; i++) {
            while (print!='B'){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B");
            print = 'C';
            notifyAll();
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500,1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void classC() {
        for (int i = 0; i < 5; i++) {
            while (print != 'C'){
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C");
            print = 'A';
            notifyAll();
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(500,1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


