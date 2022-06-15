package vn.codegym.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Mai Văn Hoàng", "1993-08-20", "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkyNJ9LlmSxU0TLJ1HIG-6D9BiO32gX3wv0tk_8qS6NtlW1KX2nk78Hjl7QSGf0kWeXbg&usqp=CAU"));
        customers.add(new Customer("Mai Văn Hoàng", "1993-08-20", "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkyNJ9LlmSxU0TLJ1HIG-6D9BiO32gX3wv0tk_8qS6NtlW1KX2nk78Hjl7QSGf0kWeXbg&usqp=CAU"));
        customers.add(new Customer("Mai Văn Hoàng", "1993-08-20", "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkyNJ9LlmSxU0TLJ1HIG-6D9BiO32gX3wv0tk_8qS6NtlW1KX2nk78Hjl7QSGf0kWeXbg&usqp=CAU"));
        customers.add(new Customer("Mai Văn Hoàng", "1993-08-20", "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkyNJ9LlmSxU0TLJ1HIG-6D9BiO32gX3wv0tk_8qS6NtlW1KX2nk78Hjl7QSGf0kWeXbg&usqp=CAU"));
        customers.add(new Customer("Mai Văn Hoàng", "1993-08-20", "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkyNJ9LlmSxU0TLJ1HIG-6D9BiO32gX3wv0tk_8qS6NtlW1KX2nk78Hjl7QSGf0kWeXbg&usqp=CAU"));
        customers.add(new Customer("Mai Văn Hoàng", "1993-08-20", "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkyNJ9LlmSxU0TLJ1HIG-6D9BiO32gX3wv0tk_8qS6NtlW1KX2nk78Hjl7QSGf0kWeXbg&usqp=CAU"));
        customers.add(new Customer("Mai Văn Hoàng", "1993-08-20", "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkyNJ9LlmSxU0TLJ1HIG-6D9BiO32gX3wv0tk_8qS6NtlW1KX2nk78Hjl7QSGf0kWeXbg&usqp=CAU"));
        customers.add(new Customer("Mai Văn Hoàng", "1993-08-20", "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkyNJ9LlmSxU0TLJ1HIG-6D9BiO32gX3wv0tk_8qS6NtlW1KX2nk78Hjl7QSGf0kWeXbg&usqp=CAU"));
        customers.add(new Customer("Mai Văn Hoàng", "1993-08-20", "Hà Nội", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQkyNJ9LlmSxU0TLJ1HIG-6D9BiO32gX3wv0tk_8qS6NtlW1KX2nk78Hjl7QSGf0kWeXbg&usqp=CAU"));

        String a = "abc";

        request.setAttribute("a", a);

        request.setAttribute("customers", customers);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
