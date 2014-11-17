package threadsproducerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CubbyHole2 {
	private int contents;
	private boolean available = false;
	private Lock aLock = new ReentrantLock();
	private Condition condVar = aLock.newCondition();

	@SuppressWarnings("finally")
	public int get(int who) {
		aLock.lock();
		try {
			while (!available) {
				try {
					condVar.await();
				} catch (InterruptedException e) {
				}
			}
			available = false;
			System.out.println("Consumer " + who + " got: " + contents);
			condVar.signalAll();
		} finally {
			aLock.unlock();
			return contents;
		}
	}

	public void put(int who, int value) {
		aLock.lock();
		try {
			while (available) {
				try {
					condVar.await();
				} catch (InterruptedException e) {
				}
			}
			contents = value;
			available = true;
			System.out.println("Producer " + who + " put: " + contents);
			condVar.signalAll();
		} finally {
			aLock.unlock();
		}
	}
}
