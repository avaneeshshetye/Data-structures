package com.Avaneesh;
import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
public class Main {



    public static void main(String[] args) {

        System.out.println("Stack Assignment");
        ArrayStack <Object> myStack = new ArrayStack<Object>(10);
        int size = myStack.size();
        System.out.println("Size before push "+ myStack.size());
        myStack.push("4");
        System.out.println("Size after push "+ myStack.size());
        System.out.println("Element on top " + myStack.top());

        myStack.push("6");
        System.out.println("Size after push "+ myStack.size());
        System.out.println("Element on top " + myStack.top());

        myStack.push("9");
        System.out.println("Size after push " + myStack.size());
        System.out.println("Element on top " + myStack.top());

        //Object ArrayStack = myStack.pop();
        System.out.println("Element  popped out " + myStack.pop());
        System.out.println("Element on top " + myStack.top());
        System.out.println("Size after pop " + myStack.size());

        System.out.println("Element  popped out " + myStack.pop());
        System.out.println("Element on top " + myStack.top());
        System.out.println("Size after pop " + myStack.size());

        System.out.println("Element  popped out " + myStack.pop());
        System.out.println("Element on top " + myStack.top());
        System.out.println("Size after pop " + myStack.size());

        System.out.println("Is stack empty: " + myStack.empty());


    }
}
