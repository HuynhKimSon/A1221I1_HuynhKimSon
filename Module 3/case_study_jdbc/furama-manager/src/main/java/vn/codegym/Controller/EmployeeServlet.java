package vn.codegym.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
//                try {
//                    delete(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
                break;
            default:
                try {
                    show(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                try {
//                    create(request, response);
//
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
                break;
            case "search":
//                try {
//                    findBy(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
                break;
            default:
                try {
                    show(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String status = request.getParameter("status");
        request.setAttribute("status", status);
        //request.setAttribute("list", customerService.findAll());
        request.getRequestDispatcher("/employee/employee.jsp").forward(request, response);
    }
}
