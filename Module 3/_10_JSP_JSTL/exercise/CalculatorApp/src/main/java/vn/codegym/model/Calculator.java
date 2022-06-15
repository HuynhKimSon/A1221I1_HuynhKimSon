package vn.codegym.model;

public class Calculator {
    private double firstOperand;
    private String operator;
    private double secondOperand;

    public Calculator() {
    }

    public Calculator(double firstOperand, String operator, double secondOperand) {
        this.firstOperand = firstOperand;
        this.operator = operator;
        this.secondOperand = secondOperand;
    }

    public double getFirstOperand() {
        return firstOperand;
    }

    public String getOperator() {
        return operator;
    }

    public double getSecondOperand() {
        return secondOperand;
    }

    public void setFirstOperand(double firstOperand) {
        this.firstOperand = firstOperand;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setSecondOperand(double secondOperand) {
        this.secondOperand = secondOperand;
    }

    public double calculate(double firstOperand, String operator, double secondOperand) {
        double res = 0.0;
        switch (operator) {
            case "+":
                res = firstOperand + secondOperand;
                break;
            case "-":
                res = firstOperand - secondOperand;
                break;
            case "*":
                res = firstOperand * secondOperand;
                break;
            default:
                try {
                    res = firstOperand / secondOperand;
                } catch (Exception ex) {
                    System.err.print(ex);
                }
                break;
        }
        return res;
    }
}
