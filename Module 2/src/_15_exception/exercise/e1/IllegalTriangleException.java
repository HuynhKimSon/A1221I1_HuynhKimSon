package _15_exception.exercise.e1;

public class IllegalTriangleException extends Exception {

    public IllegalTriangleException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
