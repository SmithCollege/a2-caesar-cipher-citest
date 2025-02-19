// Do not change the line below. It lets Gradle find your 
// Classes to build the project
package a1template;

public interface IndexAccess<T> {

    /** Returns the value stored at a given index
     * @param i index of element to read
     * @return value stored at the given index
     */
    public T get(int i);

    /** Returns the value stored at a given index plus the offset
     * @param i index of element to read
     * @param offset adjust index by this value
     * @return value stored at the given index
     */
    public T get(int i, int offset);

    /** Stores the given value at the given index
     * @param i index of location to store
     * @param val value to store at given index
     */
    public void set(int i, T val);


}
