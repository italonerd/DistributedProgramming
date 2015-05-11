package threads.pool;

public class WorkerThread implements Runnable {
	private int workerNumber;

	WorkerThread(int number) {
		workerNumber = number;
	}

	public void run() {
		for (int i = 0; i <= 100; i += 20) {
			// Perform some work ...
			System.out.println("Worker number: " + workerNumber
					+ ", percent complete: " + i);
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}

	}
}