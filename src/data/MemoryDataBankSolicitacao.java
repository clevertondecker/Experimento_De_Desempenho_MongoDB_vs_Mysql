package data;

import java.util.ArrayList;
import java.util.List;

import coordenada.Coordenada;

public class MemoryDataBankSolicitacao implements IDao<Coordenada>{
    
    private List<Coordenada> MemoryDataBankSolicitacao = new ArrayList<>(); 

    @Override
    public void save(Coordenada t) {
        this.MemoryDataBankSolicitacao.add(t);
    }

    @Override
    public List<Coordenada> list() {
        return MemoryDataBankSolicitacao;
    }

    @Override
    public void list(List<Coordenada> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



  
   
}