/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChattChain;

import java.util.HashMap;
import java.util.Scanner;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Hlsmith1
 */
class HashTable {

    private int TABLE_SIZE;
    private int size;
    private LinkedHashEntry[] table;

    public static int randomCount = 1;

    /*Constructor*/
    public HashTable(int ts) {
        size = 0;
        TABLE_SIZE = ts;
        table = new LinkedHashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    /*Function to get number of key-value pairs*/
    /**
     *
     * @return number of key-value pairs
     */
    public int getSize() {
        return size;
    }

    /**
     * Function to clear hash table
     */
    public void clear() {
        randomCount = 1;
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }

    }

    /**
     *
     * @param x
     * @return a hash value for a given string
     */
    private int myHash(String x) {
        int hashVal = x.hashCode();
        hashVal %= TABLE_SIZE;
        if (hashVal < 0) {
            hashVal += TABLE_SIZE;
        }
        return hashVal;

    }

    /**
     *
     * @param key
     * @return value of a specified key
     */
    public int get(String key) {
        int hash = (myHash(key) % TABLE_SIZE);
        if (table[hash] == null) {
            return -1;
        } else {
            LinkedHashEntry entry = table[hash];
            while (entry != null && !entry.key.equals(key)) {
                entry = entry.next;
            }
            if (entry == null) {
                return -1;
            } else {
                return entry.value;
            }
        }
    }

    /**
     *
     * @param value
     * @return key of a specified value
     */
    public String getKey(String value) {
        System.out.println("Number of tables: " + TABLE_SIZE);
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.println("Searching table " + i);
            LinkedHashEntry entry = table[i];
            while (entry != null && entry.value != Integer.getInteger(value)) {
                entry = entry.next;
            }
            if (entry.value == Integer.getInteger(value)) {
                return entry.key;
            }
        }
        return null;
    }

    /**
     * Insert a key-value pair
     *
     * @param key
     * @return value
     */
    public void insert(String key, int value) {
        int hash = (myHash(key) % TABLE_SIZE);
        if (table[hash] == null) {
            table[hash] = new LinkedHashEntry(key, value);
        } else {
            LinkedHashEntry entry = table[hash];
            while (entry.next != null && !entry.key.equals(key)) {
                entry = entry.next;
            }
            if (entry.key.equals(key)) {
                entry.value = value;
            } else {
                entry.next = new LinkedHashEntry(key, value);
            }
        }
        System.out.println("Hash Key = " + hash);
        size++;
    }

    /**
     * convenience function
     */
    public void fillWithRandom() {
        Random r = new Random();
        int low = 65;
        int high = 90;

        String insertStmt = "";
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 4; i++) {
                insertStmt += (char) (r.nextInt(high - low) + low);
            }
            insert(insertStmt, (j * randomCount));
            insertStmt = "";
            ++randomCount;
        }
    }

    /**
     * Remove a key-value pair
     *
     * @param key
     */
    public void remove(String key) {
        int hash = (myHash(key) % TABLE_SIZE);
        if (table[hash] != null) {
            LinkedHashEntry prevEntry = null;
            LinkedHashEntry entry = table[hash];
            while (entry.next != null && !entry.key.equals(key)) {
                prevEntry = entry;
                entry = entry.next;
            }
            if (entry.key.equals(key)) {
                if (prevEntry == null) {
                    table[hash] = entry.next;
                } else {
                    prevEntry.next = entry.next;
                    size--;
                }
            }
        }
    }

    /**
     * Resizes the underlying structure
     *
     * @return a new HashTable
     */
    public HashTable resize() {
        HashTable htNew = new HashTable(TABLE_SIZE * 2);

        for (int i = 0; i < TABLE_SIZE; i++) {
            LinkedHashEntry entry = table[i];
            while (entry != null) {
                htNew.insert(entry.key, entry.value);
                entry = entry.next;
            }
        }
        TABLE_SIZE *= 2;
        return htNew;
    }

    /**
     * Print hash table
     */
    public void printHashTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("\nBucket " + (i + 1) + " : ");
            LinkedHashEntry entry = table[i];
            while (entry != null) {
                System.out.print(entry.value + " ");
                entry = entry.next;
            }
        }
    }

    /**
     * Print hash table by key
     */
    public void printHashTableKeys() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("\nBucket " + (i + 1) + " : ");
            LinkedHashEntry entry = table[i];
            while (entry != null) {
                System.out.print(entry.key + " ");
                entry = entry.next;
            }
        }
    }

    /**
     * Print hash table by key and value
     */
    public void printHashTableBoth() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("\nBucket " + (i + 1) + " : ");
            LinkedHashEntry entry = table[i];
            while (entry != null) {
                System.out.print(entry.key + "(" + entry.value + ") ");
                entry = entry.next;
            }
        }
    }

    public void bucketFillFactor() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("\nBucket " + (i + 1) + " : ");
            LinkedHashEntry entry = table[i];
            int sum = sumLinkedHashes(i);
            while (entry != null) {
                double factor = (double)entry.value/sum;
                System.out.format("\tBucket Value: " + entry.value +"  Bucket Factor %.3f", factor);
                entry = entry.next;
            }   
              
        }
    }
    
    public int sumLinkedHashes(int index)
    {
        LinkedHashEntry entry = table[index];
        if(entry == null)
            return 0;
        
        int sum = 0;
        while (entry != null) {
            sum += entry.value;
            entry = entry.next;
        }         
        return sum;
    }
}

/*Class LinkedHashEntry*/
class LinkedHashEntry {

    String key;
    int value;
    LinkedHashEntry next;

    /*Constructor*/
    LinkedHashEntry(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}


public class HashTablesChainingListHeadsTest {

    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hash Table Test\n\n");
        System.out.println("Enter size of table.");
        /*Make object of HashTable*/
        HashTable ht = new HashTable(scan.nextInt());

        char ch = 0;
        /* Perform HashTable operations*/
        do {
            System.out.println("\nHash Table Operations");
            System.out.println("----------------------\n");
            System.out.println("b. Print hash table both");
            System.out.println("c. Clear");
            System.out.println("d. Remove");
            System.out.println("f. Fill with random data");
            System.out.println("g. Get");
            System.out.println("i. Insert");
            System.out.println("k. Print hash table keys");
            System.out.println("r. Resize");
            System.out.println("s. Show size");
            System.out.println("v. Print hash table values");
            System.out.println("p. Bucket Factor");
            String choice = scan.next();
            switch (choice) {
                case "I":
                case "i":
                    System.out.println("Enter key and value");
                    ht.insert(scan.next(), scan.nextInt());
                    break;

                case "D":
                case "d":
                    System.out.println("Enter key");
                    ht.remove(scan.next());
                    break;

                case "G":
                case "g":
                    System.out.println("Enter key");
                    System.out.println("Value = " + ht.get(scan.next()));
                    break;

                case "C":
                case "c":
                    ht.clear();
                    System.out.println("Hash Table Cleared\n");
                    break;

                case "S":
                case "s":
                    System.out.println("Size = " + ht.getSize());
                    break;

                case "K":
                case "k":
                    ht.printHashTableKeys();
                    break;

                case "B":
                case "b":
                    ht.printHashTableBoth();
                    break;

                case "V":
                case "v":
                    ht.printHashTable();
                    break;

                case "f":
                case "F":
                    System.out.println("Fill list");
                    ht.fillWithRandom();

                case "r":
                    System.out.println("Resize Structure");
                    ht = ht.resize();
                    System.out.println();
                    break;
                
                case "p":
                    System.out.println("Bucket Factor");
                    ht.bucketFillFactor();
                    break;
                    
                default:
                    System.out.println("Enter key and value");
                    ht.insert(scan.next(), scan.nextInt());
                    break;
            }
//End switch
            System.out.println("\nDo you want to continue? Yes or No");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }

}
