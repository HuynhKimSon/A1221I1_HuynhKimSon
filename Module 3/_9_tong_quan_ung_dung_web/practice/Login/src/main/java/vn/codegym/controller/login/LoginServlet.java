package vn.codegym.controller.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/login/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("inputUsername");
        String passWord = request.getParameter("inputPassword");

        request.setAttribute("userName", userName);
        request.setAttribute("passWord", passWord);

        request.getRequestDispatcher("/showInfo/index.jsp").forward(request, response);
    }
}
