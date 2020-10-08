package vn.test.thread;

class Main extends Thread {
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            System.out.println("Thread is running..." + this.getName());
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        Main m2 = new Main();
        m.start();
        m2.start();
    }
}
