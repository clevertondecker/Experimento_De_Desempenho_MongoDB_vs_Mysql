package data;

import coordenada.Coordenada;
import java.util.List;

public interface IDao <T>{
		
		void save(T t);
                				
		void list(List<Coordenada> list);
	
                List<Coordenada> list();
}