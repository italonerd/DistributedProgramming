package threads.pool;

import java.util.Date;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest3 {
	public static void main(String[] args) {
		int numWorkers = (int) (Math.random() * 5) + 5;

		System.out.println("Number of workers: " + numWorkers);

		ExecutorService tpes = Executors.newCachedThreadPool();
		CallableWorkerThread workers[] = new CallableWorkerThread[numWorkers];
		CompletionService<String> cs = new ExecutorCompletionService<String>(tpes);
		for (int i = 0; i < numWorkers; i++) {
			workers[i] = new CallableWorkerThread(i,
					(int) (Math.random() * 1000));
			cs.submit(workers[i]);
		}

		for (int i = 0; i < numWorkers; i++) {			
			try {
				System.out.println(cs.take().get());;
			} catch (InterruptedException e) {
			} catch (ExecutionException e) {
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
