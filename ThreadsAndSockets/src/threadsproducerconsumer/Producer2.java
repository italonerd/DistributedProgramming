package threadsproducerconsumer;


public class Producer2 extends Thread {
    private CubbyHole2 cubbyhole;
    private int number;

    public Producer2(CubbyHole2 c, int number) {
        cubbyhole = c;
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            cubbyhole.put(number, i);
			System.out.println("Producer " + number + " put: " + i);
            try {
                this.sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) { }
        }
    }   
}
