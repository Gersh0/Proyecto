package proyecto;

public class Automovil extends Carro {
    private final Cilindraje cilindraje;

    public Automovil(String marca, String modelo, String serial, Cilindraje cilindraje, boolean estado, boolean disponible) {
        super(marca, modelo, serial, cilindraje, estado, disponible);
        this.cilindraje = cilindraje;
    }

    public Cilindraje getCilindraje() {
        return cilindraje;
    }

    public double getPrecio() {
        return 20000;
    }

}
