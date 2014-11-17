package threadsproducerconsumer;

public class CubbyHole {
	private int contents = -1;
	private boolean available = false;

	public synchronized int get() {
		while (!available) {
			try {
				// wait for Producer to put value
				wait();
			} catch (InterruptedException e) {
			}
		}
		available = false;
		// notify Producer that value has been retrieved
		notifyAll();
		return contents;
	}

	public synchronized void put(int value) {
		while (available) {
			try {
				// wait for Consumer to get value
				wait();
			} catch (InterruptedException e) {
			}
		}
		contents = value;
		available = true;
		// notify Consumer that value has been set
		notifyAll();
	}

}
