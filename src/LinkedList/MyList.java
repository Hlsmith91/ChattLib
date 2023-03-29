/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author Hlsmith1
 */
public class MyList {
    public Node headNode;
    public static int count = 0;
    
    public MyList(){
        headNode = null;
    }
    
    public void AddToEnd(int data){
        count++;                
        if(headNode == null){
            headNode = new Node(data);
            //headNode.Print();
        }else{
            headNode.AddToEnd(data);
        }
    }
    
    public void AddToBeginning(int data){
        if(headNode == null){
            headNode = new Node(data);
        }else{
            //we must do this in this order!!!
            Node temp = new Node(data);
            temp.next = headNode;
            headNode = temp;
        }
    }
        
    public void append(int data){
        AddToEnd(data);
    }
    
    public void push(int data){
        AddToBeginning(data);
    }
    
    public void AddSorted(int data){
        count++;
        if(headNode == null){ //if list is empty
            headNode = new Node(data);
        }else if(data < headNode.data){
            AddToBeginning(data);
        }
        else{
            headNode.AddSorted(data);
        }
    }
         
    public void Print(){
        if(headNode != null){
            headNode.Print();
        }
    }
    
    public boolean isPresent(int data){
        Node temp = headNode;
        while(temp != null){
            if(temp.data == data){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    public boolean isEmpty(){
        Node temp = headNode;
        if(temp == null){
            return true;
        }
        return false;
    }
    
    public int size(){
        return count;
    }
    
    public int removeHead(){
        if(isEmpty()){
            throw new IllegalStateException("EmptyListException");
        }
        count --;
        int data = headNode.data;
        headNode = headNode.next;
        return data;
    }
    
    public boolean deleteNode(int delValue){
        Node temp = headNode;
        if(isEmpty()){
            return false;
        }
        if(delValue == headNode.data){
            headNode = headNode.next;
            count--;
            return true;
        }
        
        while(temp.next != null){
            if(temp.next.data == delValue){
                temp.next = temp.next.next;
                count --;
                return true;
            }
            temp = temp.next;
        }
          return false;  
    }
        
    public void deleteNodes(int delValue){
        Node currNode = headNode;
        Node nextNode;
        
        
        while(currNode != null && currNode.data == delValue){
            headNode = currNode.next;
            currNode = headNode;
        }
        while(currNode != null){
            nextNode = currNode.next;
            if(nextNode != null && nextNode.data == delValue){
                currNode.next = nextNode.next;
            }
            else{
                currNode = nextNode;
            }
        }
    }
    
    public void freeList(){
        headNode = null;
        count = 0;
    }
    
    public void reverse(){
        Node curr = headNode;
        Node prev = null;
        Node next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
                  
        }
        headNode = prev;
    }
    
    public void removeDuplicate(){
        Node curr = headNode;
        while(curr != null){
            //traverse
            if(curr.next != null && curr.data == curr.next.data){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;  //increment
            }
                    
        }
    }
    
    //Just another way to traverse the list
    /**
     * 
     * @param value
     * @return 
     */
    public int Indexof(int value){
        Node current = this.headNode;
        for(int i = 0; i < this.findLength(); i++){
            if(current.data == value){
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    private int findLength() {
        Node curr = headNode;
        int counter = 0;
        while(curr != null){
            counter++;
            curr = curr.next;
        }
        return counter;
    }
    
    public int get (int index){
        if(isEmpty()){
            throw new IllegalStateException("EmptyListException");
        }
        if(index > count-1 || index < 0){
            throw new IndexOutOfBoundsException();
        }
        
        Node curr = headNode;
        int counter = 0;
        while(curr != null){
            if(counter == index){
                return curr.data;
            }
            curr = curr.next;
            counter++;
        }
        return -1;
    }
    
    public int set(int index, int value){
        if(isEmpty()){
            throw new IllegalStateException("EmptyListException");
        }
        if(index > count-1 || index < 0){
            throw new IndexOutOfBoundsException();
        }
        
        Node curr = headNode;
        int counter = 0;
        int retVal = 0;
        while(curr != null){
            if(counter == index){
                retVal = curr.data;
                curr.data = value;        
                return retVal;
            }
            curr = curr.next;
            counter++;
        }
        return -1;
    }
    
    public boolean compareList(MyList ll){
        return compareList(headNode, ll.headNode);
    }
    
    public boolean compareList(Node head1, Node head2){
        if(head1 == null && head2 == null){
            return true;
        }
        else if((head1 == null) || (head2 == null)||
            (head1.data != head2.data)){
            return false;}
        else{
            return compareList(head1.next, head2.next);
        }
    }
    
    public boolean loopDetect(){
        Node slowPtr;
        Node fastPtr;
        slowPtr = fastPtr = headNode;
        
        while(fastPtr.next != null && fastPtr.next.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                System.out.println("Loop found");
                return true;
            }
        }
            System.out.println("Loop not found.");
            return false;
    }
    
    public Node loopPointDetect(){
        Node slowPtr;
        Node fastPtr;
        slowPtr = fastPtr = headNode;
        while(fastPtr.next != null && fastPtr.next.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                return slowPtr;
            }
        }
        return null;
    }
    
    public void removeLoop(){
        Node loopPoint = loopPointDetect();
        if(loopPoint == null){
            return;
        }
    }
}
