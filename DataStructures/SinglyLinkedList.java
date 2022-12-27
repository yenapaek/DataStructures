package DataStructures;
/*
 * Singly Linked List implementation
 * 
 * Linked List: a linear sequence of nodes; each node contains an object and a pointer to the next node
 */
public class SinglyLinkedList<E>{
    
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }

        public Node<E> getNext(){
            return next;
        }

        public E getElement(){
            return element;
        }

        public void setNext(Node<E> n){
            next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){}

    // accessor
    // size
    public int size() { return size; }
    
    // isEmpty
    public boolean isEmpty(){ return size == 0; }
    
    // first
    public E first(){
        if (isEmpty()) { return null; }
        return head.getElement();
    }

    // last
    public E last(){
        if (isEmpty()) { return null; }
        return tail.getElement();
    }

    // get
    public E get(int i){
        if (i < 0 || i >= size){
            return null;
        }
        Node<E> curr = head;
        int n = 0;
        while (n <= i && curr != null){
            curr = curr.getNext();
            n++;
        }
        return curr.getElement();
    }

    // update

    // addFirst
    public void addFirst(E e){
        Node<E> newest = new Node<E>(e, head);
        head = newest;
        if (isEmpty()){
            tail = head;
        }
        size++;
    }
    
    // addLast
    public void addLast(E e){
        Node<E> newest = new Node<E>(e, null);
        if (isEmpty()){ // if list was empty
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    // removeFirst
    public E removeFirst(){
        if (isEmpty()){ return null; } // if list is empty
        E removed = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty()) { // if list is empty now
            tail = null;
        }
        return removed;
    }

    // removeLast
    // public E removeLast(){
    //     Node<E> curr = head;
    //     Node<E> prev = head;

    //     E removed = tail.getElement();

    //     while (curr != null && curr.getNext() != null){
    //         if (curr.getNext() == null){

    //         }
    //         prev = curr;
    //         curr = curr.getNext();
    //     }
    //     tail = prev;
    //     return removed;
    // }

    // insert
    

    // delete
    // public boolean delete(E e){
    //     Node<E> curr = head;
    //     if (isEmpty()) return false;

    //     while (curr != null && curr.getNext() != null){
    //         if (curr.getNext().getElement() == e){
    //             curr.setNext(curr.getNext().getNext());

    //         } else {
    //             curr = curr.getNext();
    //         }
    //     }

    //     return true;
    // }

    // value from end
    
    // reverse
    
    // remove
}
