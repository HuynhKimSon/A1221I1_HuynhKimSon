package _11_dsa_stack_queue.exercice.e1;

import java.util.Stack;

public class MyGenericStack<T> {
    private Stack<T> stack;

    public MyGenericStack() {
        stack = new Stack<>();
    }

    public void push(T element) {
        stack.add(element);
    }

    public void reverse() {
        Stack<T> stackReverse = new Stack<>();
        for (int i = size() - 1; i <= 0 ; i--) {
            stackReverse.add(stack.get(i));
        }
        stack.clear();
        stack = stackReverse;
    }

    public T get(int index) {
        return stack.get(index);
    }

    public int size() {
        return stack.size();
    }

}
