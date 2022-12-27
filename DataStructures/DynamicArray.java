package DataStructures;
import java.util.*;

/*
 * Dynamic Array implementation
 * 
 * ArrayList or Dynamic Array: a indexable container that has a resizable length
 * 
 */
public class DynamicArray<E> implements Iterable<E> {
    // size
    // []
    private int size = 0; // curr # of elements
    private static final int CAPACITY = 16;
    private E[] data;

    public DynamicArray(){
        this(CAPACITY);
    }

    public DynamicArray(int capacity){
        data = (E[]) new Object[capacity];
    }

    // accessor methods
    public int size(){ return size; }
    public boolean isEmpty(){ return size == 0; }

    // getElement
    public E get(int n) throws IndexOutOfBoundsException {
        // if (n >= size || n < 0) {
        //     throw new IndexOutOfBoundsException("Illegal index");
        // }
        return data[n];
    }

    public E set(int n, E e) throws IndexOutOfBoundsException {      
        if (n >= size || n < 0) {
            throw new IndexOutOfBoundsException("Illegal index");
        }
        E temp = data[n];
        data[n] = e;

        return temp;
    }

   public void insert(int n, E e) throws IndexOutOfBoundsException {
        // if (n >= size + 1 || n < 0) {
        //     throw new IndexOutOfBoundsException("Illegal index");
        // }

        // size = # of current elements
        // data.length = size of data array
        if (size == data.length){
            resize(size*2);
        }

        // shift elements
        for (int k = size - 1; k > n; k--){
            data[k+1] = data[k];
        }
        data[n] = e;
        size++;
   }

   public void push(E e){
        insert(size + 1, e);
   }

   public E pop(){
        return get(size);
   }

   public E delete(int n) throws IndexOutOfBoundsException {
        // if (n >= size || n < 0) {
        //     throw new IndexOutOfBoundsException("Illegal index");
        // }
        E removed = data[n];

        // shift elements
        for (int k = n; k < size - 1; k++){
            data[k] = data[k+1];
        }

        size--;
        return removed;
   }

   public int search(E e){
        for (int i = 0; i < size; i++){
            if (data[i] == e){
                return i;
            }
        }
        return -1;
   }

   private void resize(int capacity){
    // make new home
    E[] temp = (E[]) new Object[capacity];

    // copy over to new home
    for (int i = 0; i <= size; i++){
        temp[i] = data[i];
    }

    // set as new home
    data = temp;
   }

   public Iterator<E> iterator(){
    return new Iterator<E>() {
        int i = 0;

        public boolean hasNext(){
            return i < size;
        }

        public E next() {
            return data[i++];
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    };
   }

   public static void main(String[] args){
    DynamicArray<Integer> arr = new DynamicArray<>();
    arr.push(1);
    arr.push(2);
    arr.push(3);

   // Prints [1, 2, 3]
   for (int i = 0; i < arr.size() + 1; i++) System.out.println(arr.get(i));

   // Prints [-2, 3, 6, 7]
   System.out.println(arr);

   }
}
