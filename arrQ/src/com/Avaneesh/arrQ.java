package com.Avaneesh;
import java.util.*;
/*public class arrQ {
}*/
public class arrQ<E> implements Queue<E> {
    private E[] data; // generic array used for storage
    private int front = 0; // index of the front element
    private int rear = -1; // index of the rear element
    private int size = 0; // size of the quque

    public arrQ(int capacity) { //constructs queue with given capacity
        data = (E[]) new Object[capacity];
    }

    public int size() { //Returns the number of elements in the queue [-1 if queue is empty]
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    public void enqueue(E e) throws IllegalStateException {
        /*Inserts an element at the rear of the queue */
        if (size == data.length) throw new
                IllegalStateException("Queue is full");
        rear = (rear + 1) % data.length;
        data[rear] = e;
        size++;
    }

    public E first() { /*Returns, but does not remove, the first
element of the queue (null if empty)*/
        if (isEmpty()) return null;
        return data[front];

    }

    public E dequeue() {
        if (isEmpty()) return null;
        E answer = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size -- ;
        return answer;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    public E booleanisEmpty() {
        return null;
    }
}
