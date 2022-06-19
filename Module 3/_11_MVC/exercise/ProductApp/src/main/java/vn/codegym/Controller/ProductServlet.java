package vn.codegym.Controller;

import vn.codegym.Model.Product;
import vn.codegym.Service.IProductService;
import vn.codegym.Service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
                deleteProduct(request, response);
                break;
            case "search":
                break;
            default:
                showProductList(request, response);
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
                createProduct(request, response);
                break;
            default:
                showProductList(request, response);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        response.sendRedirect("/product");
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("idProduct"));
        String nameProduct = request.getParameter("nameProduct");
        double priceProduct = Double.parseDouble(request.getParameter("priceProduct"));
        String descriptionProduct = request.getParameter("descriptionProduct");
        String manufacturer = request.getParameter("manufacturer");
        String imgProduct = request.getParameter("imgProduct");

        Product product = new Product(id, nameProduct, priceProduct, descriptionProduct, manufacturer, imgProduct);
        productService.save(product);

        response.sendRedirect("/product");
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products", productService.findAll());
        request.getRequestDispatcher("/product/list.jsp").forward(request, response);
    }
}
