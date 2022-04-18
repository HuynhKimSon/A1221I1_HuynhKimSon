package _11_dsa_stack_queue.practice.p4;

public class MyStack {
    private int[] arr;
    private int size;
    private int index = 0;

    public MyStack() {

    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        if (index == 0) {
            return true;
        }
        return false;
    }

    public MyStack(int size) {
        this.size = size;
        arr = new int[size];
    }

    public boolean isFull() {
        if (index == size) {
            return true;
        }
        return false;
    }

    public void push(int item) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        arr[index] = item;
        index++;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is null");
        }
        return arr[--index];
    }
}
