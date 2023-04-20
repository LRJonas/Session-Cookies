package com.example.atividade2.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginService {

    public void validateLogin(String usuario, String senha, HttpServletRequest request) throws Exception{

        if(usuario.isEmpty() || usuario == null){
            throw new Exception("Usuário Inválido");
        }
        if(senha.isEmpty() || senha == null){
            throw new Exception("Senha Inválido");
        }
        if(usuario.equals("admin") && senha.equals("admin")){
            HttpSession session = request.getSession();
            session.setAttribute("is_logged_in", true);
            session.setAttribute("usuario", usuario);
            //usuário deveria estar logado
        }else{
            throw new Exception("Usuário ou senha inválidos");
        }

    }
}
