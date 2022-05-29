package com.Avaneesh;


interface PositionalList<E> {

        /**
         * Returns the number of elements in the list
         *
         * @return
         */
        int size();

        /**
         * Tests whether the list is empty or not
         *
         * @return
         */
        boolean isEmpty();

        /**
         * Returns the first position in the list
         *
         * @return
         */
        Position<E> first();

        /**
         * Returns the last position in the list
         *
         * @return
         */
        Position<E> last();

        /**
         * Returns the position before Position p in the list
         *
         * @param p
         * @return
         * @throws IllegalArgumentException
         */
        Position<E> before(Position<E> p) throws IllegalArgumentException;

        /**
         * Returns the position after Position p in the list
         *
         * @param p
         * @return
         * @throws IllegalArgumentException
         */
        Position<E> after(Position<E> p) throws IllegalArgumentException;

        /**
         * Inserts an element e at the front of the list and returns its position
         *
         * @param e
         * @return
         */
        Position<E> addFirst(E e);

        /**
         * Inserts an element e at the end of the list and returns its position
         *
         * @param e
         * @return
         */
        Position<E> addLast(E e);

        /**
         * Inserts an element e just before position p and returns its position
         *
         * @param p
         * @param e
         * @return
         * @throws IllegalArgumentException
         */
        Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

        /**
         * Inserts an element e just after position p and returns its position
         *
         * @param p
         * @param e
         * @return
         * @throws IllegalArgumentException
         */
        Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;

        /**
         * Replaces the element at Position p and returns the replaced element
         *
         * @param p
         * @param e
         * @return
         * @throws IllegalArgumentException
         */
        E set(Position<E> p, E e) throws IllegalArgumentException;

        /**
         * Removes the element at position p and returns the removed element
         *
         * @param p
         * @return
         * @throws IllegalArgumentException
         */
        E remove(Position<E> p) throws IllegalArgumentException;
    }

    class Node<E> implements Position<E> {

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
            if (next == null)
                throw new IllegalArgumentException("Position no longer valid");
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




