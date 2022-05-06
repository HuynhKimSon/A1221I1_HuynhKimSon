package _11_dsa_stack_queue.exercise.e1;

public class TestReverse {
    public static void main(String[] args) {
        System.out.println("1. Stack of integers");
        stackOfIntegers();
    }

    private static void stackOfIntegers() {
        MyGenericStack<Integer> stack = new MyGenericStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.printf("1.1. Arrays elements from stack : ");
        for (int i = 0; i < stack.size(); i++) {
            System.out.printf(" %d", stack.get(i));
        }
        stack.reverse();
        System.out.printf("\n1.2. Reverse elements from stack : ");
        for (int i = 0; i < stack.size(); i++) {
            System.out.printf(" %d", stack.get(i));
        }

    }
}
