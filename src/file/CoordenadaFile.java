package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import coordenada.Coordenada;
import data.MemoryDataBankSolicitacao;

public class CoordenadaFile {

    public CoordenadaFile() {
    }

    public void LerArquivo(String nomeArquivo, MemoryDataBankSolicitacao mdb) {
        try {
            FileReader arq = new FileReader(nomeArquivo);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha

            int cont = 0;
            while (linha != null) {
                cont++;
                String[] linhaArray = linha.split(",");

                double id = Double.parseDouble(linhaArray[0]);
                String data = linhaArray[1];
                double latitude = Double.parseDouble(linhaArray[2]);
                double longitude = Double.parseDouble(linhaArray[3]);

                Coordenada c = new Coordenada(id, data, latitude, longitude);
                mdb.save(c);
                linha = lerArq.readLine();
                 //System.out.println("Cont : " + cont + "ID : " + id + "Data : " + data + " Latitude: " + latitude + " Longitude: " + longitude);
            }

            arq.close();

        } catch (Exception e) {
            throw new IllegalArgumentException("Nao foi possivel abrir o arquivo!");
        }

    }
}
