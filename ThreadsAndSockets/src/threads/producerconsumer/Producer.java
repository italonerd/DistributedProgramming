package threads.producerconsumer;

import threads.PingPong;

public class Producer extends Thread {
    private CubbyHole cubbyhole;
    private int number;

    public Producer(CubbyHole c, int number) {
        cubbyhole = c;
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            cubbyhole.put(i);
            System.out.println("Producer #"+number+" put:"+i);
            try {
                this.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) { }
        }
    }   
}
