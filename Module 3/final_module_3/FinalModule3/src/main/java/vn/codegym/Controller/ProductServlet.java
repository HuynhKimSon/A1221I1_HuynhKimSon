package vn.codegym.Controller;

import vn.codegym.Model.Product;
import vn.codegym.Service.IProductService;
import vn.codegym.Service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product", ""})
public class ProductServlet extends HttpServlet {

    private IProductService productService = new ProductServiceImpl();

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
        productService.delete(IDs);
        response.sendRedirect("/product?status=deleteSuccess");
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
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String category = request.getParameter("category");

        Product product = new Product(id, name, price, quantity, color, description, category);
        productService.save(product);
        if (id > 0) {
            response.sendRedirect("/product?status=editSuccess");
        } else {
            response.sendRedirect("/product?status=createSuccess");
        }
    }

    private void findBy(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException, ServletException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        request.setAttribute("key", key);
        request.setAttribute("value", value);
        request.setAttribute("listProduct", productService.findBy(key, value));
        request.setAttribute("listCategory", productService.findAllCategory());
        request.getRequestDispatcher("/product/list.jsp").forward(request, response);
    }

    private void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String status = request.getParameter("status");
        if (status != null) {
            request.setAttribute("status", status);
        }
        request.setAttribute("listProduct", productService.findAll());
        request.setAttribute("listCategory", productService.findAllCategory());
        request.getRequestDispatcher("/product/list.jsp").forward(request, response);
    }
}
