package vn.codegym.controller;

import vn.codegym.model.Calculator;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {

    Calculator calculator = new Calculator();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double firstOperand = Double.valueOf(request.getParameter("firstOperand"));
        String operator = request.getParameter("operator");
        Double secondOperand = Double.valueOf(request.getParameter("secondOperand"));

        Double result = calculator.calculate(firstOperand, operator, secondOperand);

        request.setAttribute("firstOperand", firstOperand);
        request.setAttribute("operator", operator);
        request.setAttribute("secondOperand", secondOperand);
        request.setAttribute("result", result);

        request.getRequestDispatcher("show.jsp").forward(request, response);

    }
}
