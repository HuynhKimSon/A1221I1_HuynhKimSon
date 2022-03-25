package _4_class_obj.exercise.e3;

public class Fan {
    private final int SLOW = 1;
    private final int MEDIUM = 2;
    private final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";

    public Fan(int speed, boolean on, String color, double radius) {
        this.speed = speed;
        this.on = on;
        this.color = color;
        this.radius = radius;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public String getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String toString() {
        String state = "";
        if (this.isOn()) {
            state = "fan is on" + " - " + getSpeed() + " - " + getRadius() + " - " + getColor() + " - " + isOn();
        } else {
            state = "fan is off" + " - " + getSpeed() + " - " + getRadius() + " - " + getColor() + " - " + isOn();
        }
        return state;
    }

    public static void main(String[] args) {
        Fan state_1 = new Fan(3, true, "yellow", 10);
        Fan state_2 = new Fan(2, false, "blue", 5);
        System.out.println(state_1.toString());
        System.out.println(state_2.toString());
    }
}