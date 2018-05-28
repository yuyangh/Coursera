package Chap8_MultiThread;
import java.util.Date;

public class TestThreadDaemon {
    public static void main(String args[]) {
        Thread t = new MyThread1();
        t.setDaemon(true);
        t.start();

        System.out.println("Main--" + new Date());
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
        System.out.println("Main End");
    }
}

class MyThread1 extends Thread {
    public void run() {
        // it does not show until 10 because it is a Daemon thread
        for (int i = 0; i < 10; i++) {
            System.out.println(i + "--" + new Date());
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }
}
