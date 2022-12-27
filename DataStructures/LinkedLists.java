package DataStructures;

import java.util.HashSet;

class Node {
    Node next;
    int data;

    public Node(int data){
        this.next = null;
        this.data = data;
    }
}

public class LinkedLists {
    public Node head = null;
    public Node tail = null;

    public void add(int data){
        Node newNode = new Node(data);

        if (head == null){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    public void print(){
        Node curr = head;

        while(curr != null){
            System.out.print(curr.data +" ");
            curr = curr.next;
        }
        System.out.println();
    }

    /*
     * 2.1 Remove Dups
     * Remove duplicates from an unsorted linked list
     * 
     * Time Complexity: O(n)
     * 
     */
    public void removeDups() {
       /*
        *   Hash Table - store numbers in hash table, if contains remove  
        */  
        // Node curr = head, prev = null;
        // HashSet<Integer> hash = new HashSet<>();
        // if (head == null) return;

        // // iterate through list until end of list
        // while(curr != null){
        //     // if already contains, remove curr
        //     if (hash.contains(curr.data)){
        //         prev.next = curr.next;
        //     }
        //     // else add curr to hashset
        //     else {
        //         hash.add(curr.data);
        //         prev = curr;
        //     }
        //     curr = curr.next;
        // }

        /*
        *   No temp buffers allowed: in-place operation
        *   Two runners
        *   Time Complexity: O(n^2)
        */  
        Node curr = head; // iterates through list
        while (curr != null){
            Node run = curr; // checks for duplicates
            while (run.next != null){
                if (run.next.data == curr.data){
                    run.next = run.next.next;
                } else {
                    run = run.next;
                }
            }
            curr = curr.next;
        }
    } 

    /*
     * 2.2 Return Kth to Last
     * find kth to the last element of a singly linked list
     * 
     * Time Complexity: O(n)
     *
     */

    // two pointers
    // 1 goes k times
    // 2 goes until 1 hits end
    public Node kthElement(int k){
        Node p1 = head, p2 = head;

        for (int i = 0; i < k; i++){
            if (p1 == null) return null;
            p1 = p1.next;
        }

        while (p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    /*
     * 2.3 Delete Middle Node
     * delete a node between the first and last node
     * 
     * Input: c from a-b-c-d-e-f
     * Output: a-b-d-e-f
     * 
     */
    public boolean deleteMid(Node c){
        if (c == null || c.next == null){
            return false;
        }
        Node next = c.next;
        c.data = next.data;
        c.next = next.next;
        return true;
    }

    /*
     * 2.4 Partition
     * all values < x come before other values
     * 
     * Input: 5 from 3-5-8-5-10-2-1
     * Output: 3-1-2 - 10-5-5-8
     * 
     */
    // public void partition(int x){
        // create two lists, merge later
    //     Node n = head;
    //     Node start = n, tail = n;

    //     while (n != null){
    //         Node next = n.next;
    //         if (n.data < x){
    //             // insert head
    //             n.next = start;
    //             start = n;
    //         } else {
    //             // insert tail
    //             tail.next = n;
    //             tail = n;
    //         }
    //         n = next;
    //     }
    //     tail.next = null;

    //     head = start;
    // }

    

    public static void main(String[] args){
        /*
         * 2.1 Remove Dups
         */
        LinkedLists list = new LinkedLists();

        list.add(1);
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(2);
        list.add(7);
        list.add(3);
        list.print();
        list.removeDups();
        list.print();

        /*
         * 2.2 Return Kth to Last
         */
        LinkedLists list2 = new LinkedLists();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.print();
        System.out.println(list2.kthElement(2).data);

        /*
         * 2.3 Delete Middle Node
         */
        // LinkedLists list3 = new LinkedLists();
        // list3.add(1);
        // list3.add(2);
        // list3.add(3);
        // list3.add(4);
        // list3.add(5);
        // list3.add(6); 
        // list3.add(7);
        // list3.print();
        // System.out.println(list3.deleteMid(2).data);

        /*
         * 2.4 Partition
         */
        // LinkedLists list4 = new LinkedLists();
        // list4.add(4);
        // list4.add(2);
        // list4.add(3);
        // list4.add(4);
        // list4.add(5);
        // list4.add(6); 
        // list4.add(4);
        // list4.print();
        // list4.partition(5);
        // list4.print();
    }
}