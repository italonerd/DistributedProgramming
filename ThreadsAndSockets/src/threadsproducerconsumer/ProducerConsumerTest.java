package threadsproducerconsumer;

public class ProducerConsumerTest {
	public static void main(String[] args) {
		CubbyHole c = new CubbyHole();
		
		Producer p = new Producer(c, 1);
		p.start();
		Consumer cs = new Consumer(c, 1);
		cs.start();

	}
}
