/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.bean.Professor;
import model.dao.CadastroDAO;

/**
 *
 * @author Senai
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller", "/cadastro", "/login", "/logar", "/inicio"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String paginaAtual = request.getServletPath();
        
        if (paginaAtual.equals("/cadastro")) {
            
            request.getRequestDispatcher("/WEB-INF/jsp/cadastro.jsp").forward(request, response);
            
        } else if (paginaAtual.equals("/login")) {
            
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            
        } else if (paginaAtual.equals("/inicio")) {
            
            request.getRequestDispatcher("/WEB-INF/jsp/inicio.jsp").forward(request, response);
            
        } 
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String paginaAtual = request.getServletPath();
        CadastroDAO dao = new CadastroDAO();
        Professor bean = new Professor();
        
        if (paginaAtual.equals("/cadastro")) {
            
            bean.setNome(request.getParameter("nome"));
            bean.setMatricula(request.getParameter("matricula"));
            bean.setAdmissao(Date.valueOf(request.getParameter("admissao")));
            bean.setSenha(request.getParameter("senha"));
            bean.setCpf(request.getParameter("cpf"));
            bean.setArea_id(Integer.parseInt(request.getParameter("area_id")));
            
            dao.cadastrar(bean);
            
            response.sendRedirect("./login");
            
        } else if (paginaAtual.equals("/logar")) {
            
            String cpf, senha;
            cpf = request.getParameter("cpf");
            senha = request.getParameter("senha");
            
            if (dao.logar(cpf, senha)) {
                response.sendRedirect("./inicio");
            } else {
                response.sendRedirect("./login");
            }
            
        }
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
