/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StacksAndQueues;

/**
 *
 * @author Hlsmith1
 */
public class LinkedListQueue {

    /**
     * Count of number of elements in queue
     */
    public static int size = 0;

    /**
     * The first Node
     */
    private Node head;

    /**
     * The last Node
     */
    private Node tail;

    /**
     * Initialize the Linked List
     */
    public LinkedListQueue() {
        this.head = this.tail = null;
    }

    public boolean add(int dataItem) {
        return enqueue(dataItem);
    }

    public boolean enqueue(int dataItem) {
        //create a new node
        size++;
        Node temp = new Node(dataItem);
        //if queue is empty, then the new node is both head and tail.
        if (this.tail == null) {
            head = tail = temp;
            return true;
        }

        // Add the new node at the end of the queue
        this.tail.next = temp;
        this.tail = temp;
        return true;

    }

    public Node poll() {
        if (head == null) {
            return null;
        }
        Node temp = new Node(head.data);
        temp = head.next;
        size--;
        return temp;
    }

    public Node peek() {
        if (head == null) {
            return null;
        }
        return head;
    }

    public Node dequeue() {

        //if queue is empty, return null.
        if (head == null) {
            return null;
        }

        size--;
        Node temp = head;
        head = head.next;
        //if head become NULL, then change rear also as NULL
        if (head == null) {
            tail = null;
        }

        return temp;
    }
    
    private static void printList(LinkedListQueue.Node head)
    {
        LinkedListQueue.Node temp = head;
        while(temp != null)
        {
            System.out.format("%d-> ", temp.data);
            temp = temp.next;
        }
        System.out.println(" ");
    }
    
    public int length()
    {
        return size;
        
     
    }
    public static void main(String[] args)
    {
        LinkedListQueue q = new LinkedListQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.printList(q.head);
        q.dequeue();
        q.printList(q.head);
        System.out.println("dequeue: "+ q.dequeue().data);
        q.printList(q.head);
        q.enqueue(100);
        q.enqueue(200);
        q.enqueue(300);
        q.printList(q.head);
        System.out.println("Length: "+ q.length());
        System.out.println("poll: "+ q.poll().data);
        q.printList(q.head);
    }
            
            
         
    /**
     * Nested class to define the Linked List node.
     */
    private class Node {

        int data;
        Node next;

        //Constructor
        private Node(int dataItem) {
            data = dataItem;
            next = null;
        }
    }
}
