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
public class RecursiveSampler {
 
    public static void main(String[] args) {
        int a = myRecursiveMethod(10);
    }
 
     private static int myRecursiveMethod(int i) {
        System.out.println(i);
        i--;
        if (i == 0){
            return 0;
        }
        return myRecursiveMethod(i);
    }
}
