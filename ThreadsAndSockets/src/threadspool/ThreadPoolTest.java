package threadspool;

import java.util.concurrent.*;

public class ThreadPoolTest {
	public static void main(String[] args) {
		int numWorkers = (int) (Math.random() * 10);
		int threadPoolSize = (int) (Math.random() * 4) +1;
		
		System.out.println("Number of workers: "+numWorkers);
		System.out.println("Number of pool size: "+threadPoolSize);
		
		ExecutorService tpes = Executors.newFixedThreadPool(threadPoolSize);

		WorkerThread[] workers = new WorkerThread[numWorkers];
		for (int i = 0; i < numWorkers; i++) {
			workers[i] = new WorkerThread(i);
			tpes.execute(workers[i]);
		}
		
		tpes.shutdown();
	}
}
