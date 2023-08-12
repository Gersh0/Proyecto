package proyecto;

public class Vendedor extends Empleado {
    private int ventasRealizadas;

    public Vendedor(String nombre, String cc, String tel, double salario, int ventasRealizadas) {
        super(nombre, cc, tel, salario);

        this.ventasRealizadas = ventasRealizadas;
    }

    public int getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(int ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }

    public void bonificacion() {//Agregar al problema.
        this.setSalario(getSalario() * 1.05);
    }


}
