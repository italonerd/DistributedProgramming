package threadspool;

import java.util.concurrent.*;

public class ThreadPoolTest2 {
	public static void main(String[] args) {
		int numWorkers = (int) (Math.random() * 10);
		
		System.out.println("Number of workers: "+numWorkers);

		ExecutorService tpes = Executors.newCachedThreadPool();
		CallableWorkerThread workers[] = new CallableWorkerThread[numWorkers];
		Future futures[] = new Future[numWorkers];

		for (int i = 0; i < numWorkers; i++) {
			workers[i] = new CallableWorkerThread(i);
			futures[i] = tpes.submit(workers[i]);
		}
		for (int i = 0; i < numWorkers; i++) {
			try {
				System.out.println("Ending worker: " + futures[i].get());
			} catch (Exception e) {
			}
		}
	}
}