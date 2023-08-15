package proyecto;

import java.util.Arrays;

public class Cliente extends Persona {
    private Venta[] comprasRealizadas;

    public Cliente(String nombre, String cc, String tel) {

        super(nombre, cc, tel);

    }


    public Venta[] getVentasC() {
        return comprasRealizadas;
    }

    public int getCantVentas() {
        return comprasRealizadas.length;
    }

    //Método buscar venta
    public void registrarCompra(Venta venta) {
        if (comprasRealizadas==null){
            comprasRealizadas=new Venta[1];
            comprasRealizadas[0]=venta;
        }else{
            this.comprasRealizadas = Arrays.copyOf(this.comprasRealizadas, this.comprasRealizadas.length + 1);
            comprasRealizadas[comprasRealizadas.length - 1] = venta;
        }

    }



    public void delVenta(String code) {
        int i = 0;
        while (!code.equals(comprasRealizadas[i].getCodigo())) {
            i++;
        }
        System.arraycopy(comprasRealizadas, i + 1, comprasRealizadas, i, comprasRealizadas.length - 1 - i);
        comprasRealizadas = Arrays.copyOf(comprasRealizadas, comprasRealizadas.length - 1);
    }


}
