package proyecto;

public abstract class Persona {

    private String nombre, cedula, tel;

    public Persona(String nombre, String cedula, String tel) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tel = tel;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTel() {
        return tel;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


}
