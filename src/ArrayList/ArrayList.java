/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayList;
import AccountPinNumber.AccountPinAmount;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;




/**
 * @author Hlsmith1
 */


public class ArrayList<E> implements Iterable<E>{
    public static int timesDoubled = 1;
    
    //The default initial capacity
    public static final int INITIAL_CAPACITY = 10;
    
    /** Underlying data array */
    private E[] theData;
    
    /** The current size */
    private int size = 0;
    
    /** The current capacity */
    private int capacity = 0;
    
    
    /** the constructor */
    public ArrayList(){
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }
   
    /**
     * 
     * @param anEntry
     * @return 
     */
    public boolean add(E anEntry){
        if(size == capacity){
            reallocate();
        }
        theData[size] = anEntry;
        size++;
        return true;
    }

    /**
     * 
     * @param index
     * @param anEntry 
     */
    public void add(int index, E anEntry){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if( size == capacity){
            reallocate();
        }
        //Shift data in elements from index to size -1 
        for(int i = size; i > index; i--){
            theData[i] = theData[i-1];
        }
        //insert the new item
        theData[index] = anEntry;
        size++; 
    }
    
    //Set inserts the new item at the specified index and returns the value
    // that was previously stored at that index
    /**
     * 
     * @param index
     * @param newValue
     * @return 
     */
    public E set(int index, E newValue){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;        
    }
    
    /**
     * 
     * @param index
     * @return 
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }
    
    
    //Double array to spread out the cost of copying
    private void reallocate(){
        capacity = 2 * capacity;
        theData = Arrays.copyOf(theData, capacity);
        timesDoubled++;
        System.out.println("Doubled: " + timesDoubled + " new size = " + capacity);               
    }
   
    /**
     * Print entire list
     */
   public void printAll(){
       System.out.println("------------------");
       for(int i =0; i<size; i++){
           System.out.print("| " + i + " |");
           System.out.println(theData[i] +" |");           
       }
       System.out.println("------------------");
   }
    
    /**
     * 
     * @param index
     * @return 
     * 
     * 
     */
    //To remove an  item, the items that follow it must be moved forward to close up
    // the space. The item removed is returned as the method result.
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = theData[index];
        for(int i = index +1; i < size; i++){
            theData[i-1] = theData[i];
        }
        size--;
        return returnValue;
    }
    
     
    public <E extends Comparable> E max() {
       Iterator<? extends E> i = this.iterator();
       E candidate = i.next();

       while (i.hasNext()) {
           E next = i.next();
           if (next.compareTo(candidate) > 0)
               candidate = next;
       }
       return candidate;
    }
    
    public E max(Comparator<? super E> comp){
       Iterator<? extends E> i = this.iterator();
       E candidate = i.next();

       while (i.hasNext()) {
           E next = i.next();
           if (comp.compare(next, candidate) > 0)
               candidate = next;
       }
       return candidate;
    }
    
    public <E extends Comparable> E min() {
       Iterator<? extends E> i = this.iterator();
       E candidate = i.next();

       while (i.hasNext()) {
           E next = i.next();
           if (next.compareTo(candidate) < 0)
               candidate = next;
       }
       return candidate;
    }
    
    public E min(Comparator<? super E> comp){
       Iterator<? extends E> i = this.iterator();
       E candidate = i.next();

       while (i.hasNext()) {
           E next = i.next();
           if (comp.compare(next, candidate) < 0)
               candidate = next;
       }
       return candidate;
    }
    
    public <E extends Number> Number average(){
        // avoid divide by zero exception
        if(size <= 0)
            return 0.00;
        if(theData == null)
            return 0.00;
  
        Number sum = sum();
        Number avg;
        if(theData[0] instanceof Integer)
            avg = (Integer)sum / size;
        else if(theData[0] instanceof Double)
            avg = (Double)sum / size;
        else
            avg = (Double)sum / size;
        
        return avg;
    }
     
    public Number average(String propName){
        // avoid divide by zero exception
        if(size <= 0)
            return 0.00;
        
        Number sum = sum(propName);
        Number avg;
        if(sum instanceof Integer)
            avg = (Integer)sum / size;
        else if(sum instanceof Double)
            avg = (Double)sum / size;
        else
            avg = (Double)sum / size;
        
        return avg;
    }
    
    public Number sum(String propName){

        Number sum = 0.00;
        for(int i =0; i<size; i++){
            Number propVal = getPropValue(theData[i], propName);
            if(propVal instanceof Integer)
                sum = (Integer)sum + (Integer)propVal;
            else if(propVal instanceof Double)
                sum = (Double)sum + (Double)propVal;
            else
                sum = (Double)sum + (Double)propVal;
        }

        return sum;
    }
    
     public <E extends Number> Number sum(){

        Number sum = 0;
        for(int i =0; i<size; i++){
            if(theData[i] instanceof Integer)
                sum = (Integer)sum + (Integer)theData[i] ;
            else if(theData[i]  instanceof Double)
                sum = (Double)sum + (Double)theData[i] ;
            else
                sum = (Double)sum + (Double)theData[i] ;
        }

        return sum;
    }
    
    private Number getPropValue(Object obj, String propName)
    {
        // Check for Data. 
        // NOTE: (I would make a private function to check data and 
        // call it from any method in thids class that uses theData
        if(theData == null)
            throw new NullPointerException("There is no data.");
        
        Double retVal = 0.00;
        
        try{           
            Class c = theData[0].getClass();            
            Method[] allMethods = c.getDeclaredMethods();

            for (Method m : allMethods) {
                String mname = m.getName();

                // check to see if the function matches
                if (!mname.equals(propName)) {
                    continue;
                }

                retVal = (Double)m.invoke(obj);
                // exit after we find the value that we need
                break;

            }
        } catch(IllegalAccessException illEx){
            
        }catch(InvocationTargetException illEx){
            
        }
                
        return retVal; 
    }
     
     
     
     
    /**
     * 
     * @param startIndex
     * @param endIndex
     * @return 
     */
    // Remove a range of elements
    public boolean removeRange(int startIndex, int endIndex){
        boolean status = false;
        if (startIndex < 0 || startIndex >= size) {
            throw new ArrayIndexOutOfBoundsException(startIndex);
        }else if (endIndex < 0 || endIndex >= size) {
            throw new ArrayIndexOutOfBoundsException(endIndex);
        }
        if (endIndex < startIndex) {
            int buffer = endIndex;
            endIndex = startIndex;
            startIndex = buffer;
        }
        int counter = 0;
        for(int i = startIndex; i <= endIndex; i++){
            theData[i] = theData[endIndex + counter];  //<<<Changed from last time.
            status = true;
            --size;
            counter++;
        }
        
        return status;
    }
    
     public void clear() {
        this.removeRange(0, length()-1);
    }
    
    /**
     * 
     * @return 
     */
    //is the list empty?
    public boolean isEmpty(){
        if(size ==0){
            return true;
        }
        return false;
    }
    
    
    public boolean contains(E obj){
        //boolean contains = false;
        if(!(obj == null)){
            if(!(obj == this)){
                for(int i = 0; i < size; i++){
                    if(theData[i].equals(obj)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * 
     * @return 
     */
    public int length(){
        return size;
    }
    
    
    @Override
    public Iterator iterator(){
        return new ArrayIterator();
    }
    
    public boolean hasNext(){
        return size > 0;
    }
    
    public E next(){
        return theData[--size];
    }

    public String[] toArray(String[] string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private class ArrayIterator implements Iterator<E>{
        private int i = size;
        @Override
        public boolean hasNext(){
            return i>0;
        }
      
        @Override
        public E next(){
            return theData[--i];
        }
    }
}
