package com.example.atividade2.service;

import com.example.atividade2.service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        LoginService service = new LoginService();


        try {
            service.validateLogin(usuario, senha, request);
            response.sendRedirect("http://localhost:8080/login/pagina.jsp");
            //se entrou aqui é pq não teve nenhum erro
        } catch (Exception e) {
            String msg = e.getMessage();
            response.sendRedirect("http://localhost:8080/login/index.jsp?msg=" + msg);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        session.setAttribute("is_logged_in", false);
        session.invalidate();

        resp.sendRedirect("http://localhost:8080/login/index.jsp");
    }
}
