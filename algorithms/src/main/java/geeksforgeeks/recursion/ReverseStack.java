package geeksforgeeks.recursion;

import java.util.Stack;

public class ReverseStack {

    public static void reverse(Stack s, int count) {
        if (s == null || s.isEmpty() || s.size() == count) {
            return;
        }
        reverse(s, count++);
    }

    public static void main(String[] args) {

    }
}
