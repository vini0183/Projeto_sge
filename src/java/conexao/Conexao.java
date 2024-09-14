package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    
    private static final String url = "jdbc:mysql://localhost:3306/projeto_sge";
    private static final String user = "root";
    private static final String senha = "0183";
    
    public static Connection conectar() {
        Connection conexao = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(url, user, senha);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }
    
}
