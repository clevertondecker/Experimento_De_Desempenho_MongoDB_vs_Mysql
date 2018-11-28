/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import conexao.ConexaoMongo;
import conexao.ConexaoMysql;
import coordenada.Coordenada;
import data.MemoryDataBankSolicitacao;
import data.MongoDao;
import data.MysqlDao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Experimento {

    CoordenadaFile file = new CoordenadaFile();
    MemoryDataBankSolicitacao mdb = new MemoryDataBankSolicitacao();
    List<Coordenada> aleatorio;

    // MongoDB
    MongoDao mDao = new MongoDao();
    ConexaoMongo cxMongo = new ConexaoMongo();

    // Mysql
    ConexaoMysql cxSql = new ConexaoMysql();

    public Experimento() {
        file.LerArquivo("/home/ton/NetBeansProjects/Experimento_DB/Coordenadas/1.txt", mdb);
        //System.out.println(mdb.list());
    }

    // Busca aleatória banco
    public void ObterIndexRadom() {
        List<Coordenada> list = mdb.list();
            Collections.shuffle(list);                   
            System.out.println("Coordenadas aleatorias: " +list + "\n");
            aleatorio  = list;
}

// MongoDB Inserir
public void InserirMongo() {
        Chronometer.start();
        System.out.println("Iniciando gravação MongoBD: ");
        for (Coordenada c : mdb.list()) {
            mDao.save(c);
            Chronometer.stop();
        }
        System.out.println(Chronometer.elapsedTime() + " milisseconds to write operation in MongoDB");
    }

    public void BuscarMongo() {
        Chronometer.start();
         System.out.println("Iniciando leitura no MongoDB: ");
        mDao.list(aleatorio);
        Chronometer.stop();
        System.out.println("\n" + Chronometer.elapsedTime() + " milisseconds to read operation in MongoDB \n");
    }

    // MySQL
    public void InserirMysql() {

        MysqlDao myDao = new MysqlDao(cxSql.abrirConexao());
        System.out.println("Iniciando gravação MySQL: ");
        Chronometer.start();
    //Busca dados do mongo
        for (Coordenada c : mdb.list()) {
            myDao.save(c);
            Chronometer.stop();
        }
        System.out.println(Chronometer.elapsedTime() + " milisseconds to write operation in MySQL. \n");

    }

    public void BuscarLisMysql() {
        Chronometer.start();
         System.out.println("Iniciando leitura no Mysql: ");
        MysqlDao myDao = new MysqlDao(cxSql.abrirConexao());
        myDao.list(aleatorio);
        Chronometer.stop();
        System.out.println("\n" + Chronometer.elapsedTime() + " milisseconds to read operation in MySQL.");
    }

}
