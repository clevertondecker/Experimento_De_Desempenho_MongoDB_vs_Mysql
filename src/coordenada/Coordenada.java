package coordenada;

public class Coordenada {

    public double latitude;
    public double longitude;
    public double id;
    public String data;

 

    public Coordenada(double id, String data, double latitude, double longitude) {
        super();
        this.id = id;
        this.data = data;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Coordenada() {
    }

    public double getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setId(double id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Coordenada{" + "latitude=" + latitude + ", longitude=" + longitude + ", id=" + id + ", data=" + data + '}';
    }

  

}
