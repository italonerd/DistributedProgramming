package treadscollectionsync;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConsumerList extends Thread {
	Iterator<String> arrayIterator;
	private int number;

	public ConsumerList(Iterator<String> arrayIterator, int number) {
		this.arrayIterator = arrayIterator;
		this.number = number;
	}

	public void run() {
		while (arrayIterator.hasNext()) {
			System.out.println("Consumer #" + number + " got:"
					+ arrayIterator.next());
			try {
				this.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}

}
