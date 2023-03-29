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
public class LinkedListStack {
    
    /**
     * The variable to hold the number of elements in the stack
     */
    public static int count = 0;
    
    /**
     * The first node
     */
    private Node head;
    
    //Nested class to define linked list
    private class Node{
        int data;
        Node next;
    }
    
    //Initialize the linked list
    public LinkedListStack(){
        head = null;
    }
    
    
   /**
    * @param Value - Adds the data to the top of the stack
    */

    public void push(int value)
    {
        ++count;
        Node oldHead = head;
        head = new Node();
        head.data = value;
        head.next = oldHead;
    
    }
    
    /**
     * @return integer The value popped from the stack
     * @throws a LinkedListEmptyException
     * 
     */
    public int pop() throws LinkedListEmptyException
    {
        if(head == null)
        {
            throw new LinkedListEmptyException();
        }
        --count;
        int value = head.data;
        head = head.next;
        return value;
    }
    
    /**
     * @return 
     * Look at the object at the top of the stack without removing 
     * it from the stack.
     */
    public String peek(){
        
        if(head == null)
        {
            throw new LinkedListEmptyException();
        }
         int value = head.data;   
        String retVal = "Peek: "+ value+" is at the head of the stack.";
        return retVal;
    }
    
    public int length()
    {
        return count;
    }
    
    public int indexAt(int searchFor)
    {
        if(head == null)
        {
            throw new LinkedListEmptyException();
        }
        Node temp = head;
        int counter = 0;
        while (temp != null)
        {
            ++ counter;
            if(temp.data == searchFor)
            {
                return counter;
            }
            temp = temp.next;
        }
        return -1;
    }
    
    /**
     * 
     */
    public int valueAt(int index)
    {
        if(head == null)
        {
            throw new LinkedListEmptyException();
        }
        Node temp = head;
        int counter = 0;
        
        while(temp != null)
        {
            ++counter;
            if(counter == index)
            {
                return temp.data;
            }
            temp = temp.next;
        }
        return -1;
    }
    
    /**
     * Remove all elements of the stack
     * TODO: return the values popped.
     */
    public void popAll(){
       
     if(head == null)
     {
         throw new LinkedListEmptyException();
     }   
      
     Node temp = head;
        while(temp != null)
        {
            System.out.format("%d|->", temp.data);
            
            temp = temp.next;
        }
      head = null;
     count = 0;
     
    }
    
    /**
     * Returns boolean = Is stack empty?
     */
    public boolean isEmpty()
    {
        if(head == null)
        {
            return true;
        }
        return false;
    }
    
    
    /**
     * @param head
     * Print the entire stack top to bottom
     */
    public static void printList(Node head){
        Node temp = head;
        while(temp != null)
        {
            System.out.format("%d|->", temp.data);
            temp = temp.next;
        }
        System.out.println("");
    } 
    
    public static void main(String[] args){
        LinkedListStack lls = new LinkedListStack();
        
        lls.push(20);
        lls.push(50);
        lls.push(80);
        lls.push(40);
        lls.push(60);
        lls.push(75);
        System.out.println("Find 20: "+ lls.indexAt(20));
        System.out.println("What at index 6?  "+ lls.valueAt(6) );
        System.out.println("Empty? "+ lls.isEmpty());
        System.out.println("Length: "+ lls.length());
        printList(lls.head);
        
        System.out.println("pop: "+ lls.pop());
        System.out.println("pop: "+ lls.pop());
        System.out.println("pop: "+ lls.pop());
        printList(lls.head);
        System.out.println(lls.peek());
        lls.popAll();
        System.out.println("\nEmpty? "+ lls.isEmpty());
        
    }
}



/**
 * Return an exception thrown by empty list exception
 */
class LinkedListEmptyException extends RuntimeException{

    public LinkedListEmptyException(String message){
        super(message);
    }
    public LinkedListEmptyException(){
        super();
    }
}
