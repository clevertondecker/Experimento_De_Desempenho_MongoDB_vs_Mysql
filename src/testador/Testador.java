package testador;

import conexao.ConexaoMysql;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import coordenada.Coordenada;
import data.MemoryDataBankSolicitacao;
import data.MongoDao;
import data.MysqlDao;
import file.CoordenadaFile;
import file.Experimento;

public class Testador {

    public static void main(String[] args) {

        Experimento ex = new Experimento();
        ex.ObterIndexRadom();
        
        //Mongo
        ex.InserirMongo();      // Grava no banco OK
        ex.BuscarMongo();       //  Lê aleatorio no banco   OK 

        System.out.println("------------------------------");
        
        // MYSQL
       ex.InserirMysql();   // Grava no banco OK
       ex.BuscarLisMysql(); //  Lê no banco   OK 
    }

}
