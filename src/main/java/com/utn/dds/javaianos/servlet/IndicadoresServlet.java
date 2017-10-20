package com.utn.dds.javaianos.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IndicadoresServlet")
public class IndicadoresServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = null;

//			HttpSession session = request.getSession();
//			session.setAttribute("user", "Pankaj");
//			//setting session to expiry in 30 mins
//			session.setMaxInactiveInterval(30*60);
//			Cookie userName = new Cookie("user", user);
//			userName.setMaxAge(30*60);
//			response.addCookie(userName);
        requestDispatcher = request.getRequestDispatcher("/WEB-INF/indicadores.jsp");
        requestDispatcher.forward(request, response);
        //response.sendRedirect("LoginSuccess.jsp");

    }

}