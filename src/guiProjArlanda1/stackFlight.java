package guiProjArlanda1;

import java.util.Arrays;

public class stackFlight {
	
	private String[] stackArray;
	private int stackSize;
	private int topOfStack = -1;
	private int counter = 0;
	
	stackFlight(int size) {
		stackSize = size;
		stackArray = new String[size];
		Arrays.fill(stackArray, "-1");
	}
	
	public void push(String textField_Flight) {
		if(topOfStack +1 < stackSize) {
			topOfStack++;
			stackArray[topOfStack] = textField_Flight;
			counter++;
		} else {
			System.out.println("List is full");
		}
		System.out.print(textField_Flight + " was added to stack\n");
	}
	
	public String pop() {
		if(topOfStack >= 0) {
			System.out.println("POP " + stackArray[topOfStack] + " was removed from stack\n");
			counter--;
			return stackArray[topOfStack--];
		} else {
			System.out.print("The Stack is Empty");
		}
		return "-1";
		
	}
	
	public String peek() {
		System.out.println("Peek " + stackArray[topOfStack] + " Top of stack\n");
		return stackArray[topOfStack];
	}
	
	public int stackSize() {
		return counter;
		
	}



	private void displayTheStack() {
		// TODO Auto-generated method stub
		
	}


}
