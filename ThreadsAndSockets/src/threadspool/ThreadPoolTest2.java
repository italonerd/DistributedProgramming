package threadspool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest2 {
	public static void main(String[] args) {
		int numWorkers = (int) (Math.random() * 5)+5;
		
		System.out.println("Number of workers: "+numWorkers);

		ExecutorService tpes = Executors.newCachedThreadPool();
		CallableWorkerThread workers[] = new CallableWorkerThread[numWorkers];
		
		
		System.out.println("BEGIN sequential future tasks");
		Future futures[] = new Future[numWorkers];
		for (int i = 0; i < numWorkers; i++) {
			workers[i] = new CallableWorkerThread(i,(int)(Math.random() * 1000));
			futures[i] = tpes.submit(workers[i]);
		}
		for (int i = 0; i < numWorkers; i++) {
			try {
				System.out.println(futures[i].get());
			} catch (Exception e) {
			}
		}
		System.out.println("END sequential future tasks \n\n");
		
		
		System.out.println("BEGIN future list");
		List<Future<String>> list = new ArrayList<Future<String>>();
		
		for (int i = 0; i < numWorkers; i++) {
			int number = (int)(Math.random() * 1000);
			workers[i] = new CallableWorkerThread(i,number);
			Future<String> submit = tpes.submit(workers[i]);
			list.add(submit);
		}
		
		for (Future<String> future : list) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		System.out.println("END future list");
	}
}