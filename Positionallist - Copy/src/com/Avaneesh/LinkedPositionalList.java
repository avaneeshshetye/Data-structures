package com.Avaneesh;

import com.Avaneesh.AppointmentDetails;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList <E> implements PositionalList<E>, Iterable<E> {

    @Override
    public Iterator<E> iterator() {
        return (Iterator<E>) new ElementIterator();
    }

    /**
     * Returns iterable instance.
     */

    public Iterable<Position<E>> positions() {
        return new LinkedPositionalList<>();
    }


    private class ElementIterator implements Iterator<E> {
        PositionIterator posIterator = new PositionIterator();

        public boolean hasNext() {
            return posIterator.hasNext();
        }

        public E next() {
            return posIterator.next().getElement();
        }

        public void remove() {
            posIterator.remove();
        }
    }

    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first(); // next to report
        private Position<E> recent = null; // last reported

        public boolean hasNext() {
            return (cursor != null);
        }

        /**
         * Returns the next position in the iterator.
         */
        public Position<E> next() throws NoSuchElementException {
            if (cursor == null) throw new
                    NoSuchElementException("nothing left");
            recent = cursor;
            cursor = after(cursor);
            return recent;
        }

        /**
         * Removes element returned by call to next.
         */
        public void remove() throws IllegalStateException {
            if (recent == null) throw new
                    IllegalStateException("nothing to remove");
            LinkedPositionalList.this.remove(recent);
            recent = null; // don’t allow remove until next is called
        }
    }

    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            this.element = e;
            this.prev = p;
            this.next = n;
        }

        @Override
        public E getElement() throws IllegalStateException {
            //if (next == null)
            //    throw new IllegalArgumentException("Position no longer valid");
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {

        header = new Node(null, null, null);
        trailer = new Node(null, header, null);
        header.setNext(trailer);
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p;
        //if (node.getNext() == null)
        //    throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    private Position<E> position(Node<E> node) {
        //if (node == header || node == trailer)
        //  return null;
        return node;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Position<E> first() {
        if (header != null)
            return position(header.getNext());
        else {

            return null;
        }
    }

    @Override
    public Position<E> last() {
        return position(trailer.getPrev());
    }

    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    public Position<E> addAppointment(String v, int an, int hours, int mins)
     {

        //Need to implement code here

        Position<E> currentNodePos = first();
        while (currentNodePos != null) {
            AppointmentDetails appobj = (AppointmentDetails) currentNodePos.getElement();
            //System.out.println(currentNodePos.getElement());

            if (appobj != null) {

                if(appobj.compareTo(hours,mins) == 0){
                    return null;

                }

             

                else if(appobj.compareTo(hours,mins) > 0){

                    com.Avaneesh.AppointmentDetails app_obj_new = new com.Avaneesh.AppointmentDetails( v, an, hours, mins);
                    return addBefore(currentNodePos, (E) app_obj_new);
                }


            }

            currentNodePos = after(currentNodePos);
        }
        //insert

        //call AddBefore(pass this node)
        //*************
        return null;
    }
    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }


    private Position<E> addBetween(E e, Node<E> prev, Node<E> succ) {
        Node<E> newest = new Node<>(e, prev, succ);

        prev.setNext(newest);
        newest.setPrev(prev);
        newest.setNext(succ);
        succ.setPrev(newest);

        size++;
        return position(newest);
    }

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
            /*
            if (header==null) {
                //this is first element
                return addBetween(e, header, null);
            }
            else
                return addBetween(e, header, header.getNext());

             */
    }

    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }

    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = p.getElement();
        node.setElement(e);
        return answer;
    }

    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);
        return answer;
    }


    public void dump() {

        //PositionalList.LinkedPositionalList<String> guests = new PositionalList.LinkedPositionalList<String>();
        //Position <String> cursor = (Position<String>) this.first();
        System.out.println("************** Dumping ************");
        System.out.println("The size is " + size);
        Position<E> currentNodePos = first();
        while (currentNodePos != null) {
            AppointmentDetails appobj = (AppointmentDetails) currentNodePos.getElement();
            //System.out.println(currentNodePos.getElement());
            if (appobj != null) {
                appobj.dump();
            }
            currentNodePos = after(currentNodePos);

        }
    }
}

