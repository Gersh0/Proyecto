package proyecto;

public class Carro {

    protected static int cant = 0;//Qué vamos a usar aquí?
    protected String marca, modelo, serial, placa;
    protected boolean estado, disponible;

    protected double precio = 0;
    // protected Cilindraje cilindraje;

    public Carro(String marca, String modelo, String serial, Cilindraje tipo, boolean estado, boolean disponible) {
        super();
        cant++;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        this.disponible = disponible;
        this.serial = serial;
        placa = "";
    }

    public static int getCant() {
        return cant;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getSerial() {
        return serial;
    }

    public String getPlaca() {
        return placa;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


}
