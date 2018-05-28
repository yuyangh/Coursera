package Chap8_MultiThread.synchronizedThread;

class NormalCounter {
    public static void main(String[] args) {
        Num num = new Num();
        Thread counter1 = new Counter(num);
        Thread counter2 = new Counter(num);
        for (int i = 0; i < 10; i++) {
            if (!num.testEquals()) break;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}

class Num {
    private int x = 0;
    private int y = 0;

    /*
    while x is increasing, there might be a testing on equal
     */
    void increase() {
        x++;
        y++;
    }

    boolean testEquals() {
        boolean ok = (x == y);
        System.out.println(x + "," + y + " : " + ok);
        return ok;
    }
}

class Counter extends Thread {
    private Num num;

    Counter(Num num) {
        this.num = num;
        this.setDaemon(true);
        this.setPriority(MIN_PRIORITY);
        this.start();
    }

    public void run() {
        while (true) {
            num.increase();
        }
    }
}
