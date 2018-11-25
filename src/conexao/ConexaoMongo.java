package conexao;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

import coordenada.Coordenada;

public class ConexaoMongo {

	private Mongo conexao;
	private DB db;
	private DBCollection collection;

	public ConexaoMongo(){
		try {
			this.conexao = new Mongo("localhost");
			this.db = conexao.getDB("coordenada");
			this.collection = db.getCollection("coordenada");
		} catch (Exception e) {
			throw new IllegalArgumentException("Nao foi possivel conexão com o Mongodb!");
		}
	}
	
	public DBCollection getCollection() {
		return this.collection;
	}

}