package com.utn.dds.javaianos.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/IndicadoresServlet.jsp")
public class IndicadoresServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = null;

        //cookie para manejar datos de una pagina a otra
        HttpSession session = request.getSession();
        String user = session.getAttribute("username").toString();
        Cookie userName = new Cookie("user", user);
        userName.setMaxAge(30 * 60);
        response.addCookie(userName);

        requestDispatcher = request.getRequestDispatcher("/WEB-INF/indicadores.jsp");
        requestDispatcher.forward(request, response);
        //response.sendRedirect("LoginSuccess.jsp");

    }

}
