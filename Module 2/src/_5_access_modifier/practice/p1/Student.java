package _5_access_modifier.practice.p1;

public class Student {
    private int rollNo;
    private String name;
    private static String college = "BBDIT";

    //constructor to initialize the variable
    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    //static method to change the value of static variable
    static void change() {
        college = "CODE GYM";
    }

    //method to display values
    void display() {
        System.out.println(this.rollNo + " " + this.name + " " + college);
    }
}

