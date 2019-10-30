/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DAOFactory;
import dao.design.ICountryDAO;
import dao.design.ICustomerDAO;
import dao.ds.DBAccess;
import dao.objects.Country;
import dao.objects.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AULAFISI
 */
@WebServlet(name = "customerServlet", urlPatterns = {"/customer_per_country"})
public class customerServlet extends HttpServlet {
    
    ICountryDAO countryDAO = DAOFactory.getInstance().getCountryDAO();
    ICustomerDAO customerDAO = DAOFactory.getInstance().getCustomerDAO();
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet customerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet customerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Cargar lista de países
        List<Country> c = countryDAO.getCountries();
        request.setAttribute("countries", c);
        request.getRequestDispatcher("startPage.jsp");
        
        
        
        //Muestra automaticamente la lista de clientes relacionados al country_id = 1
        List<Customer> cus = customerDAO.getCustomerPerCountry(1);
        request.setAttribute("customers", cus);
        request.getRequestDispatcher("startPage.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Para volver a cargar la lista de países al dar al botón submit
        List<Country> c = countryDAO.getCountries();
        request.setAttribute("countries", c);
        request.getRequestDispatcher("startPage.jsp");
        
        
        
        //Para sacar lista por país de clientes
        int country_id = Integer.parseInt(request.getParameter("country_id"));
        List<Customer> cus = customerDAO.getCustomerPerCountry(country_id);
        
        request.setAttribute("customers", cus);
        request.getRequestDispatcher("startPage.jsp").forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
