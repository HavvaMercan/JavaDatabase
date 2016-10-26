package guiProjArlanda1;
import java.util.*;

public class QueueFlight {
	private LinkedList list;
	private String listNr;
	

public QueueFlight() {
	list = new LinkedList();
}

public int listSizeFun() {
	int listSize;
	if(list.size() > 0) {
		listSize = list.size();
	} else {
		listSize = 0;
	}
	return listSize;
	
}


public void enqueue(Object item) {
	System.out.println("Add Flight in Queue ... Running");
	list.add(item);
	System.out.println("Add Flight in Queue ... Done");
}

public Object dequeue() {
	System.out.println("Remove First Flight ... Running");
	Object item = list.get(1);
	list.remove(0);
	System.out.println("Remove First Flight ... Done");
	return item;
	
}

public Object peek() {
	System.out.println("Peek the List .. Done");
	return list.get(0);
	
}
}