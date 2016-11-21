import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StackQueue {
	 public static class MyQueue<T> {
	        Stack<T> stackNewestOnTop = new Stack<T>();
	        Stack<T> stackOldestOnTop = new Stack<T>();

	        public void enqueue(T value) { // Push onto newest stack
	        	int i=0;
	        	stackNewestOnTop.push(value);
	        }

	        public T peek() {
	        	while(stackOldestOnTop.isEmpty()){
	        		stackOldestOnTop.push(stackNewestOnTop.pop());
	        	}
	        
	        	 return stackOldestOnTop.peek();
	        }

	        public T dequeue() {

	        	while(!stackOldestOnTop.isEmpty()){
	        		stackNewestOnTop.push(stackOldestOnTop.pop());
	        	}
	        	while(!stackNewestOnTop.isEmpty()){
	        		stackOldestOnTop.push(stackNewestOnTop.pop());
	        	}
	        return	stackOldestOnTop.isEmpty()?null:stackOldestOnTop.pop();
	        	
	        }
	    }
	    

    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();
        
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        
//        for (int i = 0; i < n; i++) {
//            int operation = scan.nextInt();
//            if (operation == 1) { // enqueue
//                queue.enqueue(scan.nextInt());
//            } else if (operation == 2) { // dequeue
//                queue.dequeue();
//            } else if (operation == 3) { // print/peek
//                System.out.println(queue.peek());
//            }
//        }
//        scan.close();
        queue.enqueue(45); 
        queue.dequeue(); 
        queue.enqueue(56); 
        System.out.println(queue.peek());
        queue.enqueue(43);
        System.out.println(queue.peek());
        queue.dequeue();
    }
}
