package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.err.println("LOGIN GET METHOD");
        /*Chuyển hướng không kèm data*/
        response.sendRedirect("/login/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        System.err.println(username + " - " + pass);

        request.setAttribute("ten", username);
        request.setAttribute("matKhau", pass);
        /*CHuyển hướng có kèm data*/
        request.getRequestDispatcher("/login/complete.jsp").forward(request, response);
    }
}
