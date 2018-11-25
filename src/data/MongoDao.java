package data;

import java.util.ArrayList;
import java.util.List;

import org.bson.BasicBSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import conexao.ConexaoMongo;
import coordenada.Coordenada;

public class MongoDao implements IDao<Coordenada> {

    ConexaoMongo conexao;

    public MongoDao() {
        this.conexao = new ConexaoMongo();
    }

    @Override
    public void save(Coordenada c) {
        BasicDBObject coordenada = new BasicDBObject();
        coordenada.put("id", c.getId());
        coordenada.put("data", c.getData());
        coordenada.put("latitude", c.getLatitude());
        coordenada.put("longitude", c.getLongitude());

        this.conexao.getCollection().insert(coordenada);
    }

    @Override
    public void list(List<Coordenada> list) {

        List<Coordenada> coordenadas = new ArrayList<>();

        DBCursor listaDoCursor = this.conexao.getCollection().find();
        System.out.println(list);

        for (DBObject document : listaDoCursor) {

            Object id = document.get("id");
            Object data = document.get("data");
            Object latitude = document.get("latitude");
            Object longitude = document.get("longitude");

            String str1 = id.toString();
            double id1 = Double.valueOf(str1).doubleValue();

            String str2 = data.toString();
            String data2 = str2.toString();

            String str3 = longitude.toString();
            double lat3 = Double.valueOf(str3).doubleValue();

            String str4 = longitude.toString();
            double lat4 = Double.valueOf(str4).doubleValue();

            coordenadas.add(new Coordenada(id1, data2, lat3, lat4));
        }

    }

    @Override
    public List<Coordenada> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
