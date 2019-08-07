package com.bittu.coreconcepts.multithreading;

public class SynchronisedThreadPrinting {

    static int lastPrintingThreadNumber = 2;
    static int counter = 0;


    public static void main(String[] args) {
        Object lock = new Object();
        Thread th0 = new Thread(new SequencePrinter(lock, 0, 0));
        Thread th1 = new Thread(new SequencePrinter(lock, 1, 1));
        Thread th2 = new Thread(new SequencePrinter(lock, 2, 2));

        th0.start();
        th1.start();
        th2.start();
    }

    public static class SequencePrinter implements Runnable {
        Object lock;
        int threadNumber;
        int valueToPrint;


        public SequencePrinter(Object lock, int threadNumber, int valueToPrint) {
            this.lock = lock;
            this.threadNumber = threadNumber;
            this.valueToPrint = valueToPrint;
        }

        @Override
        public void run() {
            synchronized (lock) {
                while (true) {
                    if (counter >= 100) {

                        System.out.println("Thread Number :"+threadNumber+" Exiting");
                        break;
                    }
                    if (threadNumber == 0 && (lastPrintingThreadNumber == 1 || lastPrintingThreadNumber == 2)) {
                        System.out.println(valueToPrint);
                        counter++;
                        lastPrintingThreadNumber = 10 + lastPrintingThreadNumber;
                    }
                    if (threadNumber == 1 && lastPrintingThreadNumber == 12) {
                        System.out.println(valueToPrint);
                        counter++;
                        lastPrintingThreadNumber = 1;
                    }
                    if (threadNumber == 2 && lastPrintingThreadNumber == 11) {
                        System.out.println(valueToPrint);
                        counter++;
                        lastPrintingThreadNumber = 2;
                    }
                    lock.notifyAll();
                    try {
                        lock.wait(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
