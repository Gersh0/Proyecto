package proyecto;

public class Proveedor extends Persona {

    private String tipoCarros;//Lo que vende al concesionario

    public Proveedor(String nombre, String cc, String tel, String tipoCarros) {
        super(nombre, cc, tel);
        this.tipoCarros = tipoCarros;
    }

    public String getTipoCarros() {
        return tipoCarros;
    }


}
