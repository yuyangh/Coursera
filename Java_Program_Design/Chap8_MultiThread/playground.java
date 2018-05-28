package Chap8_MultiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadPoolDemo2 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        MyTask2 t1 = new MyTask2(5);
        MyTask2 t2 = new MyTask2(7);
        MyTask2 t3 = new MyTask2(8);
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.shutdown();
    }
}

class MyTask2 implements Runnable {
    int n = 10;

    public MyTask2(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 1; i <= n; i++)
            try {
                System.out.print(i);
                Thread.sleep(10);
            } catch (Exception e) {

            }
        System.out.println();
    }
}
