package proyecto;

import java.time.LocalDate;
import java.util.Date;

enum MP {
    CREDITO,
    DEBITO,
    EFECTIVO


}

class Eventas extends Exception {
    public Eventas(String e) {
        super(e);
    }
}

public class Venta {

    private String codigo;
    private Vendedor vendedor;
    private final Cliente cliente;
    private final Carro carro;
    private LocalDate fecha;
    private MP metodoP = MP.CREDITO;

    //InstanceOf(Empleado.class) o InstanceOf(Cliente.class) //ver cómo poner con personas
    public Venta(Vendedor vendedor, Cliente cliente, Carro carro, LocalDate fecha, MP metodoP) {
        super();
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.carro = carro;
        this.fecha = fecha;
        this.metodoP = metodoP;
    }
//hola

    public String getCodigo() {
        return codigo;
    }


    public Vendedor getVendedor() {
        return vendedor;
    }


    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        cliente = cliente;
    }


    public LocalDate getLocalDate() {
        return fecha;
    }


    public void setLocalDate(Date localDate) {
        this.fecha = fecha;
    }


    public MP getMetodoP() {
        return metodoP;
    }


    public void setMetodoP(MP metodoP) {
        this.metodoP = metodoP;
    }


    public double calcularVenta() throws Eventas {

        double precio = carro.getPrecio();
        Almacen.buscarEmpleado(cliente.getCedula());
        //todo para que el descuento
        if (cliente.getVentasC().length != 0) {
            precio *= 0.93;
        }

        if (carro instanceof Automovil) {

            precio *= 0.9;

        } else if (carro instanceof Campero) {
            precio *= 0.92;
        } else if (carro instanceof Deportivo) {
            precio *= 0.97;

        } else {

            throw new Eventas("No hay carro registrado");

        }

        if (metodoP.ordinal() == 2) {
            precio *= 0.97;
        }


        //(Puede ir en clase principal)cliente.setVentasC(Arrays.copyOf(cliente.getVentasC(),cliente.getVentasC().length+1));


        return precio;
    }


}
