package com.Avaneesh;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
	arrQ <Object> myqueue = new arrQ <Object> (5);
        int size = myqueue.size();
        System.out.println("Size before enqueue: " +myqueue.size());
        System.out.println("First element: " + myqueue.first());
        myqueue.enqueue("Avaneesh");
        System.out.println("Size after enqueue: " + myqueue.size());
        System.out.println("First element added by enqueue: " + myqueue.first());
        myqueue.enqueue("Avanu");
        System.out.println("Size after enqueue: " + myqueue.size());
        System.out.println("Top Element: " + myqueue.first());
        System.out.println("Removing the top element: " + myqueue.dequeue());
        System.out.println("Size after dequeue: " + myqueue.size());
        System.out.println("Top element after dequeue: " + myqueue.first());
        System.out.println(" top element: " + myqueue.first());
        System.out.println("Dequing top element: " + myqueue.dequeue());
        System.out.println("Size after dequeue: " + myqueue.size());
        

        System.out.println("Is queue empty? : "+ myqueue.booleanisEmpty());




    }
}
