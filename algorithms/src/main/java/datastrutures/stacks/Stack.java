package datastrutures.stacks;

import java.util.EmptyStackException;

/**
 * Created by archithrapaka on 3/29/17.
 */
public class Stack<E> {
    private E[] elements;
    int size;

    public Stack(int size) {
        this.elements = (E[]) new Object[size];
    }

    public void push(E that) {
        ensureCapacity();
        elements[++size] = that;
    }

    public E pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        E top = elements[--size];
        elements[size] = null; // eliminate obsolete references
        return top;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            E[] oldElements = elements;
            elements = (E[]) new Object[2 * elements.length + 1];
            System.arraycopy(oldElements, 0, elements, 0, size);
        }
    }

    public void print() {
        if (this.size == 0) {
            System.out.print("stack is empty");
        }
        for (int i = size; i > 0; i--) {
            System.out.println(elements[i]);
        }
    }

    public static void main(String[] args) {

        Stack<String> stack = new Stack<String>(11);
        stack.push("hello");
        stack.push("world");

        //stack.print();

        String top = stack.pop();
        //stack.print();

        //stack.pop();
        stack.print();
    }
}
