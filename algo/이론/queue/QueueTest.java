package 이론.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
	public static int[] queue = new int[100];
	public static int front=-1;
	public static int rear=-1;
	
	public static boolean isEmpty() {
		if(front==rear) return true;
		else return false;
		
	}
	public static boolean isFull() {
		if(rear==queue.length-1) return true;
		else return false;
		
	}
	public static void enQueue(int item) {
		if(isFull()) {
			System.out.println("Queue Full");
			return;
		}
		queue[++rear]=item;
	}
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return-1;
		}
		return queue[++front];
	}
	public static int qPeek() {
		if(isEmpty()) {
			System.out.println("Queue Empty");
			return-1;
		}
		return queue[front+1];
	}
	

	public static void main(String[] args) {
		
		enQueue(1);
		enQueue(2);
		enQueue(3);
		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());
	}

}
