/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tss
 */
@WebServlet("/customer-search")
public class CustomerSearch extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("start ricerca clienti...");

        String search = req.getParameter("search");

        System.out.println("ricerca di: " + search);

        PrintWriter wr = resp.getWriter();
        
        DbManager manager = new DbManager();
    
        List<Customer> customers = manager.searchCustomer(search);
        
        wr.println("<h1>Risultato ricerca</h1>");
        
        wr.println("<ul>");
        
        customers.forEach(c -> wr.println("<li>" + c.getName() + "</li>"));
        
        wr.println("</ul>");
        
    }

}
