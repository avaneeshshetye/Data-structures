package com.Avaneesh;

import java.util.Stack;

/*
public class ArrayStack {

}
*/

public class ArrayStack<E> extends Stack<E> {
    private E[ ] data; // generic array used for storage
    private int iIndex = 0;
    private int t = -1; // index of the top element in stack
    public ArrayStack(int capacity) { // constructs stack with given capacity
        data = (E[ ]) new Object[capacity]; }

    public int size() { return (t + 1); }
    public boolean isEmpty() { return (t == - 1); }

    public E push(E e) throws IllegalStateException {
        if (size() == data.length) throw new IllegalStateException("Stack is full");
        data[++t] = e;
        return e;
    } // increment t before storing new item

    public E top() {
        if (isEmpty()) return null;
        return data[t]; }

    public E pop() {
        if (isEmpty()) return null;
        E answer = data[t];
        data[t] = null; // dereference to help garbage collection
        t--;
        return answer; }

}
