package _11_dsa_stack_queue.practice.p1;

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
        for (int i = 0, j = size() - 1; i < size(); i++, j--) {
            stackReverse.add(stack.get(j));
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
