package treadscollectionsync;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import threadsproducerconsumer.Consumer;

public class CollectionsSyncTest {
	public static void main(String[] args) {
		// ********************** synchronizedList ************************
		ArrayList<String> crunchifyArrayList = new ArrayList<String>();

		// populate the crunchifyArrayList
		crunchifyArrayList.add("eBay");
		crunchifyArrayList.add("Paypal");
		crunchifyArrayList.add("Google");
		crunchifyArrayList.add("Yahoo");

		// Returns a synchronized (thread-safe) list backed by the specified
		// list. In order to guarantee serial access, it is critical that all
		// access to the backing list is accomplished through the returned list.
		List<String> synchronizedList = Collections
				.synchronizedList(crunchifyArrayList);

		System.out.println("synchronizedList conatins : " + synchronizedList);
		Iterator<String> arrayIterator = synchronizedList.iterator();
		ConsumerList c1 = new ConsumerList(arrayIterator, 1);		
		ConsumerList c2 = new ConsumerList(arrayIterator, 2);
		c1.start();
		c2.start();
		
	}
}
