package data;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

import conexao.ConexaoMongo;
import conexao.ConexaoMysql;
import coordenada.Coordenada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlDao implements IDao<Coordenada> {

    Connection conexao;

    public MysqlDao(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void save(Coordenada c) {
        String SQL = "INSERT INTO coordenada (`id`,`data`,`latitude`, `longitude`) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstmt = this.conexao.prepareStatement(SQL);
            pstmt.setDouble(1, c.getId());
            pstmt.setString(2, c.getData());
            pstmt.setDouble(3, c.getLatitude());
            pstmt.setDouble(4, c.getLongitude());
            pstmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void list(List<Coordenada> list) {
        try {
            Statement sta = conexao.createStatement();
            System.out.println(list);
            for (Coordenada tt : list) {
                sta.executeQuery("select * from coordenada where latitude =  " + tt.getLatitude() + "" + "and longitude = " + tt.getLongitude() );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Coordenada> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 


}
