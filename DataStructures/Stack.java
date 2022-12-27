package DataStructures;

import java.util.EmptyStackException;
/*
 * 
 * Stack - linear, one-ended DS that implements LIFO on elements
 * 
 */


public class Stack<T> {
    //StackNode
    private static class StackNode<T> {
        private StackNode<T> next;
        private T data;

        public StackNode(T data){
            this.data = data;
        }
    }

    // top
    private StackNode<T> top;

    // pop
    public T pop(){
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    // push
    public void push(T data){
        StackNode<T> t = new StackNode<T>(data);
        t.next = top;
        top = t;

    }
    // peek
    public T peek(){
        if (top == null) throw new EmptyStackException();
        return top.data;
    }
    // isEmpty
    public boolean isEmpty(){
        return top == null;
    }
}
