/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.bean.Professor;
import model.dao.CadastroDAO;

/**
 *
 * @author Senai
 */
@MultipartConfig
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
            Cookie[] cookies = request.getCookies();
            for(Cookie c: cookies) {
                if(c.getName().equals("id_professor")) {
                    request.setAttribute("id_professor", c.getValue());
                }
            }
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
            
            Part filePart = request.getPart("imagens");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            
            if(fileName != null && !fileName.isEmpty()) {
                String basePath = getServletContext().getRealPath("/") + "assets";
                File upload = new File(basePath);
                if(!upload.exists()) {
                    upload.mkdirs();
                }
                File file = new File(upload, fileName);
                try (InputStream input = filePart.getInputStream()) {
                    Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }catch(Exception e) {
                    e.printStackTrace();
                }
                bean.setImagens("assets/" + fileName);
            }else {
                bean.setImagens(null);
            }
            
            
            
            
            dao.cadastrar(bean);
            
            response.sendRedirect("./login");
            
        } else if (paginaAtual.equals("/logar")) {
            
            String cpf, senha;
            cpf = request.getParameter("cpf");
            senha = request.getParameter("senha");
            
            if (dao.logar(cpf, senha)) {
                Cookie cookie = new Cookie("id_professor", Integer.toString(bean.getId_professor()));
                response.addCookie(cookie);
                
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
