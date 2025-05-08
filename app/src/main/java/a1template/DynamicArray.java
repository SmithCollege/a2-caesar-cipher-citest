// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

public class DynamicArray<T> implements IndexAccess<T>{
    private T[] arr;
    private int offset;


    // Constructor to make a new DynamicArray Object
    public DynamicArray(int offset, T[] seq){
        arr = seq;
    }

    /** Returns the value stored at a given index
     * @param i index of element to read
     * @return value stored at the given index
     */
    public T get(int i){
        return arr[i];
    }

    public T get(int i, int offset){
        return arr[i + offset];
    }

    /** Stores the given value at the given index
     * @param i index of location to store
     * @param val value to store at given index
     */
    public void set(int i, T val){
        arr[i] = val;
    }
   
}
