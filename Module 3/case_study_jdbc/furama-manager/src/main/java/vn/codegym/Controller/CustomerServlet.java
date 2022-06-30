package vn.codegym.Controller;


import vn.codegym.Model.Customer;
import vn.codegym.Service.ICustomerService;
import vn.codegym.Service.impl.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
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
        customerService.delete(IDs);
        response.sendRedirect("/customer?status=deleteSuccess");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
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
            case "search":
                try {
                    findBy(request, response);
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

    private void create(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        int customerId = Integer.parseInt(request.getParameter("customer_id"));
        String customerType = request.getParameter("customer_type");
        String customerName = request.getParameter("customer_name");
        String customerBirthday = request.getParameter("customer_birthday");
        int customerGender = Integer.parseInt(request.getParameter("customer_gender"));
        int customerIdCard = Integer.parseInt(request.getParameter("customer_id_card"));
        int customerPhone = Integer.parseInt(request.getParameter("customer_phone"));
        String customerEmail = request.getParameter("customer_email");
        String customerAddress = request.getParameter("customer_address");

        Customer customer = new Customer(customerId, customerType, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
        customerService.save(customer);
        if (customerId > 0) {
            response.sendRedirect("/customer?status=editSuccess");
        } else {
            response.sendRedirect("/customer?status=createSuccess");
        }
    }

    private void findBy(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
//        String key = request.getParameter("key");
//        String value = request.getParameter("value");
//        request.setAttribute("key", key);
//        request.setAttribute("value", value);
//        request.setAttribute("listProduct", productService.findBy(key, value));
        request.getRequestDispatcher("/customer/customer.jsp").forward(request, response);
    }

    private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String status = request.getParameter("status");
        request.setAttribute("status", status);
        request.setAttribute("list", customerService.findAll());
        request.getRequestDispatcher("/customer/customer.jsp").forward(request, response);
    }
}
