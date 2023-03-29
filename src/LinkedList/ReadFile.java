/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Hlsmith1
 */
public class ReadFile {
    
    public static void main(String[] args) throws IOException{
        MyList list = new MyList();
        
        Scanner scan = new Scanner(new File("E://DataStructures//LinkedListEvenOdd//1KInts.txt"));
        while(scan.hasNextLine()){
            list.AddToEnd(Integer.parseInt(scan.nextLine()));
        }
        
        System.out.println("Is 3716 in the list? "+ list.isPresent(3716));
        System.out.println("Is 5 in the list? "+ list.isPresent(5));
        System.out.println("Original: "+ showStats(list));
        list.reverse();
        System.out.println("After reversal: "+ showStats(list));
        
        
    }
    
    //Take accumulatar and add even or odd and have the total of even or odd
    //and calculate the average
    private static String showStats(MyList list){
        Node curr = list.headNode;
        boolean even = false;
        int evenAccumulator = 0;
        int oddAccumulator = 0;
        int evenCounter = 0;
        int oddCounter = 0;
        int evenMin = Integer.MAX_VALUE;
        int oddMin = Integer.MAX_VALUE;
        int evenMax = Integer.MIN_VALUE;
        int oddMax = Integer.MIN_VALUE;
        
        StringBuilder retVal = new StringBuilder("List Information");
        
        while(curr != null){
            if(even){
                evenCounter++;
                evenAccumulator += curr.data;
                if(evenMin > curr.data){
                    evenMin = curr.data;
                }
                if(evenMax < curr.data){
                    evenMax = curr.data;
                }
                even = false;
            }
            else{
                oddCounter ++;
                oddAccumulator += curr.data;
                if(oddMin > curr.data){
                    oddMin = curr.data;
                }
                if(oddMax < curr.data){
                    oddMax = curr.data;
                }
                even = true;
            }//end else
            
            curr = curr.next;
        }
        retVal.append("\nEven Minimum: "+ evenMin);
        retVal.append("\tOdd Minimum: "+ oddMin);
        retVal.append("\tOverall Minimum: "+ Math.min(evenMin, oddMin));
        
        retVal.append("\nEven Maximum: "+ evenMax);
        retVal.append("\tOdd Maximum: "+ oddMax);
        retVal.append("\tOverall Maximum: "+ Math.max(evenMax, oddMax));
        
        retVal.append("\nEven Average:"+ (double) evenAccumulator/evenCounter);
        retVal.append("\tOdd Average: "+ (double) oddAccumulator/oddCounter);
        retVal.append("\tOverall Average: "+ (double) (evenAccumulator + oddAccumulator));
        
        return retVal.toString();
    }
    
}
