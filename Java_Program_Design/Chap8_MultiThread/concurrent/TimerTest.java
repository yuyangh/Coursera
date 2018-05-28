package Chap8_MultiThread.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer("display");
        TimerTask task = new MyTimerTask();
        timer.schedule(task, 1000, 1000);
    }
}

class MyTimerTask extends TimerTask {
    int n = 0;

    public void run() {
        n++;
        System.out.print(new Date());
        System.out.println("---" + n);
    }
}
