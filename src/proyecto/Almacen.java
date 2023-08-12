package proyecto;

import java.time.LocalDate;
import java.util.Arrays;

public class Almacen {
    private Carro[] carros;
    private Cliente[] clientes;
    private Empleado[] empleados;
    private String nombre;
    private String dirreccion;

    //Carro[] carros, Cliente[] clientes, Empleado[] empleados, Ventas[] ventas,
    public Almacen(String nombre, String dirreccion) {
        carros = new Carro[0];
        clientes = new Cliente[0];
        empleados = new Empleado[0];
        this.nombre = nombre;
        this.dirreccion = dirreccion;
    }

    public Carro[] getCarros() {
        return carros;
    }

    public void setCarros(Carro[] carros) {
        this.carros = carros;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public void addCliente(String nombre, String cedula, String tel) {
        Cliente client = new Cliente(nombre, cedula, tel);
        clientes = Arrays.copyOf(clientes, clientes.length + 1);
        clientes[clientes.length - 1] = client;
    }

    public void addEmpleado(String nombre, String cedula, String tel, double salario) {
        Empleado empleado = new Empleado(nombre, cedula, tel, salario);
        empleados = Arrays.copyOf(empleados, empleados.length + 1);
        empleados[empleados.length - 1] = empleado;
    }

    public void addCarro(String marca, String modelo, String serial, Cilindraje tipo, boolean disponible, boolean estado) {//Ver cómo involucrar al proveedor
        Carro carro = new Carro(marca, modelo, serial, tipo, disponible, estado);
        carros = Arrays.copyOf(carros, carros.length + 1);
        carros[carros.length - 1] = carro;
    }

    public void addVenta(Vendedor vendedor, Cliente cliente, Carro carro, LocalDate fecha, MP formaDePago) {
        cliente.registrarCompra(new Venta(vendedor, cliente, carro, fecha, formaDePago));
    }

    public int buscarCliente(String cedula) {//ver cómo poner con personas
        int i = 0;
        while (!cedula.equals(clientes[i].getCedula()) && i < clientes.length) {
            i++;
            if (i == clientes.length) {
                System.out.println("El usuario no existe");
            }
        }
        return i;
    }

    public int buscarEmpleado(String cedula) {
        int i = 0;
        while (!cedula.equals(empleados[i].getCedula()) && i < empleados.length) {
            i++;
            if (i == empleados.length) {
                System.out.println("El usuario no existe");

            }
        }

        return i;
    }

    public int buscarCarro(String marca, String modelo) { //Buscar por marca y modelo y que muestre las cilindradas;
        int i = 0;
        while (!marca.equals(carros[i].getMarca()) && !modelo.equals(carros[i].getModelo()) && i < carros.length) {
            i++;
            if (i == carros.length) {
                System.out.println("El carro no existe");

            }
        }

        return i;
    }

    public void delCliente(String cedula) {//ver cómo poner con personas
        int i = 0;
        while (!cedula.equals(clientes[i].getCedula())) {
            i++;
        }

        System.arraycopy(clientes, i + 1, clientes, i, clientes.length - 1 - i);
        clientes = Arrays.copyOf(clientes, clientes.length - 1);
    }

    public void delEmpleado(String cedula) {
        int i = 0;
        while (!cedula.equals(clientes[i].getCedula())) {
            i++;
        }

        System.arraycopy(empleados, i + 1, empleados, i, empleados.length - 1 - i);
        empleados = Arrays.copyOf(empleados, empleados.length - 1);
    }

    public void delCarro(String marca, String modelo) {
        int i = 0;
        while (!marca.equals(carros[i].getMarca()) && !modelo.equals(carros[i].getModelo())) {
            i++;
        }

        System.arraycopy(carros, i + 1, carros, i, carros.length - 1 - i);
        carros = Arrays.copyOf(carros, carros.length - 1);
    }

    public int CantidadVentasRealizasHastaAhora() {
        int cont = 0;
        for (Cliente c : clientes)
            cont += c.getCantVentas();
        return cont;
    }

    public int CantidadClientesHastaAhora() {
        return clientes.length;
    }

    public static void main(String[] args) {
        Automovil carro = new Automovil("Samsung", "GalaxyS11", "3312123", Cilindraje.ALTO, true, true);

        carro.setPlaca("ABC123");//Ya se hizo una compra.

        System.out.println(carro.getPlaca());
    }
}

