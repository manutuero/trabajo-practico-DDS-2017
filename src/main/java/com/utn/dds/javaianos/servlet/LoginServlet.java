package com.utn.dds.javaianos.servlet;

import com.utn.dds.javaianos.service.UsuarioService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebServlet("/LoginServlet.jsp")
public class LoginServlet extends HttpServlet {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
        super.init(config);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pass");
        String message;

        RequestDispatcher requestDispatcher = null;

        if (usuarioService.validarUsuario(user, pwd) == (Integer) 1) {
            HttpSession session = request.getSession();
            session.setAttribute("username", user);
            session.setAttribute("password", pwd);
            //setting session to expiry in 30 mins
            session.setMaxInactiveInterval(30 * 60);
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(30 * 60);
            response.addCookie(userName);
            requestDispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
            requestDispatcher.forward(request, response);
            //response.sendRedirect("LoginSuccess.jsp");
        } else {
            requestDispatcher = getServletContext().getRequestDispatcher("/login.jsp");
            message = "nook";
            request.setAttribute("messageLogin", message);
            requestDispatcher.forward(request, response);
        }

    }

}
