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
public class Node {
    public int data;
    public Node next;  //not really recursive
    
    //constructor
    public Node(int i){
        this.data = i;
        this.next = null;
    }
    
    public Node(int i, Node n){
        this.data = i;
        this.next = n;
    }
    
    public void Print(){
        System.out.print("|" + data + "->");
        if(next != null){
            next.Print(); 
        }
        System.out.println("");
    }
    public void Add(int data){
        if(next == null){
            next = new LinkedList.Node(data);
        }
    }
    
    public void AddToEnd(int data){
        if(next == null){ //this infers that we are at the end of the list
            next = new Node(data);
        }else{ //this infers we are not at the end of the list. The nodes 
                // are going to pass the data down the chain until if finds
                // the end node.
            next.AddToEnd(data);
            
        }
    }
    public void AddSorted(int data){
        if(next == null){
            next = new LinkedList.Node(data);
        }
        else if(data < next.data){
            Node temp = new Node(data);
            temp.next = this.next;
            this.next = temp;
        }
        else{
            next.AddSorted(data); // again, viva la recursion!!
        }
    }
    
    
}
