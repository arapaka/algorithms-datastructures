package misc;

import java.util.Stack;


public class MaxStack {

    Stack<Integer> main;

    Stack<Integer> max;

    Stack<Integer> min;

    public MaxStack() {
        main = new Stack<>();
        max = new Stack<>();
        min = new Stack<>();
    }

    public void add(Integer element) {
        if(null == element) {
            return;
        }
        if(main.isEmpty()) {
            max.add(element);
            min.add(element);
        }
        else {
            updateMaxIfNecessary(element,Operation.PUSH);
            updateMinIfNecessary(element,Operation.PUSH);
        }
        main.add(element);
    }

    public void pop() {
        if(main.isEmpty()) {
            throw new UnsupportedOperationException("Stack is Empty!");
        }
        updateMaxIfNecessary(main.peek(),Operation.POP);
        updateMinIfNecessary(main.peek(),Operation.POP);
        main.pop();
    }

    private void updateMaxIfNecessary(Integer element,Operation operation) {
        if(max.isEmpty()) {return;}

        if(operation == Operation.PUSH) {
            if(element >= max.peek()) { max.push(element); }
        }
        else {
            if(element.equals(max.peek())){max.pop();}
        }
    }

    private void updateMinIfNecessary(Integer element,Operation operation) {
        if(min.isEmpty()) {return;}
        if(operation == Operation.PUSH) {
            if(element <= min.peek()) {min.push(element);}
        }
       else {
            if(min.peek().equals(element)) {min.pop();}
        }
    }

    enum Operation {
        POP,
        PUSH
    }

    public int getMaxNum() {
        if(max.isEmpty()) {
            throw new UnsupportedOperationException("Stack is empty");
        }
        return max.peek();
    }

    public int getMinNum() {
        if(min.isEmpty()) {
            throw new UnsupportedOperationException("Stack is empty !");
        }
        return min.peek();
    }

    public static void main(String[] args) {
        int[] a = {5,8,10,13,200,3,4000};
        MaxStack maxStack = new MaxStack();
        for (int i : a) {
            maxStack.add(i);
        }
        int i = 0;
        while (!maxStack.main.isEmpty()) {
            System.out.println( " max : " + maxStack.getMaxNum());
            System.out.println( "min : " + maxStack.getMinNum());
            System.out.println("Round" + i + " complete");
            ++i;
            maxStack.pop();
        }
    }
}
