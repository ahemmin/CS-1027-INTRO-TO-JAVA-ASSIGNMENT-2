/** Class determines the operations that can be done on a stack
 * 
 * @author Hemming
 *
 * @param <T> Stack
 */

public class ArrayStack<T> implements ArrayStackADT<T> {
	private T[] stack;
	private int top;
	private int initialCapacity;
	private int sizeIncrease;
	private int sizeDecrease;

/** Constructor of class allows user to create stack with desired parameters
* 
* @param initialCap User's desired initial capacity of stack
* @param sizeInc User's desired size increase of stack capacity of stack
* @param sizeDec User's desired size decrease of stack capacity of stack
*/
	
public ArrayStack(int initialCap, int sizeInc, int sizeDec) {
	top = 0;
	stack = (T[])(new Object[initialCap]);
	this.initialCapacity = initialCap;
	this.sizeIncrease = sizeInc;
	this.sizeDecrease = sizeDec;	
}

/** Method adds block to stack
 * @param dataItem The block being added to the stack
 */

public void push(T dataItem) {
	if (top == stack.length) {
		T[] larger = (T[])(new Object[stack.length + this.sizeIncrease]);
		for (int index = 0 ; index < stack.length ; index++) {
			larger[index] = stack[index];
		}
			stack = larger; {
				stack[top] = dataItem;
			}
	}
	stack[top] = dataItem;
	top++;
}

/** Method removes block from stack
 * @return topItem The block at the top of the stack that was removed  
 */

public T pop() throws EmptyStackException {
	if (isEmpty()) {
		throw new EmptyStackException("Empty Stack");		
	}
	top--;
	T topItem = stack[top];
	stack[top] = null;
	if (top < (stack.length/4) && stack.length > this.initialCapacity) {
		T[] smaller = (T[])(new Object[stack.length - this.sizeDecrease]);
		for (int index = 0 ; index <= top ; index++) {
			smaller[index] = stack[index];
		}
		stack = smaller;
	}
	return topItem;	
}

/** Method allows user to view the block on top of the stack without removing it
 * @return stack[top-1] the top block on stack
 */

public T peek() throws EmptyStackException {
	if (isEmpty()) {
		throw new EmptyStackException("Empty Stack");		
	}
	return stack[top-1];
	
}

/** Method tells user whether the stack is empty
 * @return True or False
 */

public boolean isEmpty() {
	if (top == 0) {
		return true;
	}
	else {
		return false;
	}	
}

/** Method returns the size of the stack
 * @return top the number of entries in the stack
 */

public int size() {
	return top;	
}

/** Method returns the length of the stack
 * 
 * @return stack.length The length of the stack
 */

public int length() {
	return stack.length;
}

/** Method formats the characteristics of stack in readble fashion
 * @return String 
 */

public String toString() {
	String empty = "" ;
	for (int i = 0 ; i < this.top-1 ; i++) {
		empty = empty + " " + stack[i] + ",";
	}
	empty = empty + " " + stack[this.top-1];
	 return("Stack:" + empty);
}
}
