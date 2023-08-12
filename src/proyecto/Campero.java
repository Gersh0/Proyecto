package proyecto;

public class Campero extends Carro {
    private final Cilindraje cilindraje;

    public Campero(String marca, String modelo, String serial, Cilindraje cilindraje, boolean estado, boolean disponible) {
        super(marca, modelo, serial, cilindraje, estado, disponible);
        this.cilindraje = cilindraje;
    }

    public Cilindraje getCilindraje() {
        return cilindraje;
    }

    public double getPrecio() {
        return 50000;
    }

}
