package DataStructures;
/*
 * Queue - linear DS that implements FIFO on elements
 */

import java.util.NoSuchElementException;

public class Queue<T> {
    private static class QueueNode<T> {
        private T data;
        private QueueNode<T> next;

        public QueueNode(T data){
            this.data = data;
        }
    }

    QueueNode<T> first;
    QueueNode<T> last;

    // isEmpty
    public boolean isEmpty(){
        return first == null;
    }

    // dequeue
    public T dequeue(){
        if (first == null) throw new NoSuchElementException();
        T removed = first.data;
        first = first.next;
        if (first == null){ // if queue is empty
            last = null;
        }
        return removed; 
    }

    // enqueue
    public void enqueue(T item){
        QueueNode<T> t = new QueueNode<T>(item);
        if (last != null){ // if queue isn't empty, next to curr last will be t
            last.next = t;
        }
        last = t; // new last will be t

        if (first == null){
            first = last;
        }
    }

    // peek
    public T peek(){
        if (first == null) throw new NoSuchElementException();
        return first.data;
    }
}
