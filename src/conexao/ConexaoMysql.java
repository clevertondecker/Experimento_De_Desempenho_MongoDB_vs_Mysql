package conexao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConexaoMysql {

    private Connection conexao;

    //Local para conectar
    private final String URL = "jdbc:mysql://localhost:3306/coordenada";

    // Autenticação
    private final String USER = "root";
    private final String PASSWORD = "132567";

    //Driver
    private final String TP_CONEXAO = "com.mysql.jdbc.Driver";


    public Connection abrirConexao() {
        try {
            Class.forName(TP_CONEXAO);
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
           // System.out.println("Conectado ao MySQL!");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        } 
            return conexao;
    }

    public void fecharConexao() {
        if (conexao != null) {
            try {
                this.conexao.close();
               // System.out.println("Fechando Conexao com DB");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
