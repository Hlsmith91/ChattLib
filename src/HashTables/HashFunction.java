/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTables;

import java.util.Arrays;

/**
 *
 * @author hlsmith1
 */
public class HashFunction {

    static int collisions = 0;
    String[] theArray;
    int arraySize;
    int itemToArray = 0;
    int factor = 29;

    public static void main(String[] arg) {
        HashFunction theFunc = new HashFunction(30);
        //String[] elementsToAdd = {"1", "6", "7", "5", "17", "21", "26"};
        //theFunc.hashFunction1(elementsToAdd, theFunc.theArray);

        ////////////////
        //Second part of lecture
        //Mod hash function
        //This contains exactly 30 items to show how collisions
        //will work
        ///////////////
        String[] elementsToAdd2 = {"100", "510", "170", "214", "268", "398", "235",
            "802", "900", "723", "699", "1", "16", "999", "809", "725", "998", "978", "988",
            "990", "989", "984", "320", "321", "400", "415", "450", "50", "660", "624"};

        theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);

        theFunc.displayTheHash();
        theFunc.findKey("723");
    }

    //first part of the lecture
    HashFunction(int size) {
        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, " ");

    }

    public void displayTheHash() {
        int increment = 0;
        // 3 sections for output
        // 10 columns each section
        for (int m = 0; m < 3; m++) {
            increment += 10;
            ///////////////////
            //Top Line
            //////////////////
            for (int n = 0; n < 71; n++) {
                System.out.print("-");
            }
            System.out.println();

            for (int n = increment - 10; n < increment; n++) {
                System.out.format("| %3s " + " ", n);
            }
            System.out.println();
            /////////////////
            //Middle line
            ////////////////
            for (int n = 0; n < 71; n++) {
                System.out.print("-");
            }
            System.out.println("");

            for (int n = increment - 10; n < increment; n++) {
                if (theArray[n].equals(" ")) {
                    System.out.print(String.format("| %3s " + " ", " "));
                } else {
                    System.out.print(String.format("| %3s " + " ", theArray[n]));
                }
            }
            System.out.println("");
            /////////////////
            //Bottom Line
            ////////////////
            for (int n = 0; n < 71; n++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    ///////////////////////////////////////////////////////////////////
    //first part of lecture
    //Simple hash function that puts value in the same index that matches their 
    //value
    //Open
    //NOT A GOOD FUNCTION, JUST A DEMO
    public void hashFunction1(String[] stringsForArray, String[] theArray) {
        for (int n = 0; n < stringsForArray.length; n++) {
            String newElementVal = stringsForArray[n];
            theArray[Integer.parseInt(newElementVal)] = newElementVal;
        }
    }

    //Compressing the hash
    public void hashFunction2(String[] stringsForArray, String[] theArray) {
        for (int n = 0; n < stringsForArray.length; n++) {
            String newElementVal = stringsForArray[n];
            //Create an index to store the value in by taking the modulus
            int arrayIndex = Integer.parseInt(newElementVal) % factor;
            //for pass 2 change the factor to a prime number ie 29
            System.out.println("Modulus index = " + arrayIndex + " for value " + newElementVal);
            //Cycle through the array while we find an empty space
            while (theArray[arrayIndex] != " ") {
                ++arrayIndex;
                ++collisions;
                System.out.println("Collisions number: " + collisions + "! Try: " + arrayIndex + " Instead ");

                //if we get to the end of the array, go back to index 0 
                arrayIndex %= arraySize;
            }

            theArray[arrayIndex] = newElementVal;
        }

    }

    /////////////////////////////////////////////////////////////////
    //Returns the value stored in the hash table
    ////////////////////////////////////////////////////////////////
    public String findKey(String key) {
        //find the key's original hash key
        int arrayIndexHash = Integer.parseInt(key) % factor;
        while (theArray[arrayIndexHash] != " ") {
            if (theArray[arrayIndexHash] == key) {
                //found it, return it!!!!
                System.out.println(key + " was found in index ");
                return theArray[arrayIndexHash];
            }

            //Look in the next idnex
            ++arrayIndexHash;
            //if we get to the end of the array, go back to index 0
            arrayIndexHash %= arraySize;
        }
        //Couldn't find the key
        return null;
    }
}
