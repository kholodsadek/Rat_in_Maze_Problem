package com.mycompany.ratemaze;
public class ThreadIdExample {
    public static int [] threaId() {
        int numThreads = 5; // Replace with the actual number of threads.
        Thread[] threads = new Thread[numThreads];

        // Create and start the threads
        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new MyRunnable());
            threads[i].start();
        }

        // Store the thread IDs in an array
        int[] threadIds = new int[numThreads];
        for (int i = 0; i < numThreads; i++) {
            Thread thread = threads[i];
            threadIds[i] = (int) thread.getId();
        }

        // Print the thread IDs
//        for (int i = 0; i < numThreads; i++) {
//           return  threadIds;
////            System.out.println("Thread " + i + " ID: " + threadIds[i]);
//        }
        return threadIds;
       
    }
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            // Thread logic here
        }
    }
}