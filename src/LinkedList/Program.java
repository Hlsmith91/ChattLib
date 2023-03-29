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
public class Program {
    public static void main(String[] args) {
        Node myNode = new Node(7);
//        myNode.next = new Node(5);
//        myNode.next.next = new Node(11);
//        myNode.next.next.next = new Node(4);
//        myNode.AddToEnd(5);
//        myNode.AddToEnd(11);
//        myNode.AddToEnd(4);
        //myNode.Print();
        
        
        MyList list = new MyList();
//        list.AddToEnd(9);
//        list.AddToEnd(8);
//        list.AddToEnd(7);
//        list.AddToEnd(11);
//        
//        list.AddToBeginning(1);
//        list.AddToBeginning(2);
//        list.AddToBeginning(3);

        list.AddSorted(5986);
        list.AddSorted(34);
        list.AddSorted(12);
        list.AddSorted(1002);
        list.AddSorted(-589);
        
        list.Print();
        
        
        System.out.println("\nIs list empty: "+ list.isEmpty());
        
        System.out.println("\nIs 5986 present in the list?" + list.isPresent(5986));
        System.out.println("\nIs 5987 present in the list?" + list.isPresent(5987));
        
        list.Print();
        
        //list.removeHead();
        
        
//        list.AddSorted(9);
//        list.AddSorted(9);
//        list.Print();
        
        System.out.println("Removing the number 9 "+ list.deleteNode(9));
        list.Print();
        
//        list.AddSorted(75);
//        list.AddSorted(75);
//        list.AddSorted(75);
//        list.AddSorted(-75);
//        list.AddSorted(71);
//        
//        list.Print();
//        System.out.println("Removing the number 75");
//        list.deleteNode(75);
//        list.Print();
//        
//        list.reverse();
//        list.Print();
//        
//        list.AddSorted(34);
//        list.AddSorted(34);
//        list.AddSorted(34);
//        list.AddSorted(34);
//        list.AddSorted(34);
//        list.Print();
//        System.out.println("Removing number 34 "+ list.deleteNode(34));
//        list.Print();
//        list.deleteNodes(34);
//        list.Print();
//        list.reverse();
//        list.Print();

          list.removeDuplicate();
          
//          System.out.println("Now looking at indexes: ");
//          System.out.println("Node 1 = "+ list.get(1));
//          System.out.println("Replace 999 for node 1: "+ list.set(1,999));
//          list.Print();
          
          System.out.println("Index of 75: "+ list.Indexof(75));
          MyList newList = new MyList();
          newList.AddSorted(5986);
          newList.AddSorted(34);
          newList.AddSorted(12);
          newList.AddSorted(1002);
          newList.AddSorted(-589);
          
          System.out.println("Comparing 2 lists");
          list.Print();
          newList.Print();
          System.out.println("Are the lists the same?"+ list.compareList(newList));
          
    }
         
}

