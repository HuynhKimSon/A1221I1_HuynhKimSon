package vn.codegym.Controller;

import vn.codegym.Model.User;
import vn.codegym.Service.IUserService;
import vn.codegym.Service.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", urlPatterns = {"/user", ""})
public class UserServlet extends HttpServlet {

    private IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        System.err.println("doGet : " + action);
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "delete":
                try {
                    delete(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
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
        System.err.println("doPost : " + action);
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    create(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
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

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        String IDs = request.getParameter("id");
        userService.delete(IDs);
        response.sendRedirect("/user");
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(id, name, email, country);
        userService.save(user);

        response.sendRedirect("/user");
    }

    private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        request.setAttribute("listUser", userService.findAll());
        request.getRequestDispatcher("/user/list.jsp").forward(request, response);
    }
}
