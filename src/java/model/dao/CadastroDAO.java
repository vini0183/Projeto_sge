/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.bean.Area;
import model.bean.Professor;

/**
 *
 * @author Senai
 */
public class CadastroDAO {
    
    public void cadastrar(Professor prof) {
        try {
            
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("insert into professor(nome,matricula,admissao,senha,cpf,area_id) values (?,?,?,?,?,?);");
            stmt.setString(1, prof.getNome());
            stmt.setString(2, prof.getMatricula());
            stmt.setDate(3, prof.getAdmissao());
            stmt.setString(4, prof.getSenha());
            stmt.setString(5, prof.getCpf());
            stmt.setInt(6, prof.getArea_id());
            
            stmt.executeUpdate();
            
            stmt.close();
            conexao.close();
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Area> ler() {
        List<Area> lerArea = new ArrayList();
        try {
            Connection conexao = Conexao.conectar();
            PreparedStatement stmt = conexao.prepareStatement("select * from area");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Area bean = new Area();
                bean.setId(rs.getInt("id"));
                bean.setNome(rs.getString("nome"));
                
                lerArea.add(bean);
            }
            
            rs.close();
            stmt.close();
            conexao.close();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        return lerArea;
    }
    
    public boolean logar (String cpf, String senha) {
        boolean very = false;
        
        try {
             Connection conexao = Conexao.conectar();
           PreparedStatement stmt = conexao.prepareStatement("select * from professor where cpf = ? and senha = ?");
           stmt.setString(1, cpf);
           stmt.setString(2, senha);
           
           ResultSet rs = stmt.executeQuery();
           
           if(rs.next()) {
               very = true;
           }
           
           rs.close();
           stmt.close();
           conexao.close();
            
        }  catch(Exception e) {
            e.printStackTrace();
        }      
                
        return very;
    }
    
    
}
