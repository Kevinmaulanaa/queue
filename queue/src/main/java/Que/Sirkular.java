/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
Ini adalah implementasi dari Circular Queue menggunakan Struktur Data Array.
 * Circular Queue juga dikenal sebagai Circular Buffer, Cyclic Buffer atau Ring Buffer.
 * Circular Queue memiliki kinerja yang lebih baik daripada Antrian Linier karena dalam kasus Circular Queue, kita tidak perlu mengacak
 * elemen setelah dequeuing elemen depan.
 * Dalam kasus Linear Queue, kompleksitas waktu adalah O(n) karena ketika elemen depan dihilangkan, semua elemen yang tersisa
 * elemen perlu dikocok kembali.
 * Antrian adalah tipe data abstrak dan operasi berikut didukung:
 * - Queue
 * - deQueue
 * - Size()
 * - peekFront()
 * - peekRear()
 * Method pada Helper berikut akan diperlukan untuk dapat di implementasi:
 * - isFull [Antrian akan penuh, bila (belakang - depan == kapasitas -1) ATAU (belakang - depan == -1)
 * - isEmpty [Antrian akan kosong saat (belakang == depan)

*/
package Que;

/**
 *
 * @author ACER
 */
public class Sirkular {

	private int[] queue;
	private int capacity;
	private int front;
	private int rear;
	
	public Sirkular() {
		this(5);
	}
	
	public Sirkular(int capacity) {
		this.capacity = capacity + 1;
		queue = new int[this.capacity];
		front = 0;
		rear = 0;		
	}
	
	public synchronized boolean enQueue(int element) throws Exception {
		if(isFull()) {
			throw new Exception("Queue is full!!");
		} else {
			queue[rear] = element;
			rear = (rear + 1) % capacity;
			return true;
		}
	}
	
	public synchronized int deQueue() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is Empty!!");
		} else {
			int element = queue[front];
			front = (front + 1) % capacity;
			return element;
		}
	}
	
	public int size() {
		int size;
		if(rear > front) {
			size = rear - front;
		} else {
			size = capacity - front + rear;
		}
		
		return size;
	}
	
	public int peekFront() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is Empty!!");
		} else {
			return queue[front];
		}
	}
	
	public int peekRear() throws Exception {
		if(isEmpty()) {
			throw new Exception("Queue is Empty!!");
		} else {
			int temp = (rear - 1) % capacity; //Need to do this because rear is always pointing a step ahead
			return queue[temp];
		}
	}
	
	/*
	 * A Circular Queue would be empty when front and rear overlap or point to the same index, i.e., front = rear
	 */
	private boolean isEmpty() {
		if(rear == front) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * A Circular Queue can be full in two cases:
	 * 	- When Rear is pointing at the last element and front is pointing at the first element, so rear - front = capacity - 1
	 * 	- When Rear is right behind front in cases when array is wrapped: rear - front = -1 
	 */
	private boolean isFull() {
		if((rear - front == capacity - 1) || (rear - front == -1)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		
		Sirkular queue = new Sirkular();
		
		try {
					
			queue.enQueue(10);
			queue.enQueue(20);
			queue.enQueue(30);
			queue.enQueue(40);
			queue.enQueue(50);
			
			System.out.println("First Dequeue: " + queue.deQueue());
			System.out.println("Second Dequeue: " + queue.deQueue());
			
			System.out.println("Front element is: " + queue.peekFront());
			System.out.println("Rear element is: " + queue.peekRear());
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Size of Queue: " + queue.size());
			

	}

}
