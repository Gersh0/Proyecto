package proyecto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class Ventas extends JFrame {
    private JPanel Ventas;
    private JLabel tituloNuevaVenta;
    private JTextField inputAddCliente;
    ;
    private JTextField inputAddVendedor;
    private JTextField inputAddCarroMarca;
    private JComboBox inputAddFormaDePAgo;
    private JLabel tituloVentas;
    private JLabel tituloCarro;
    private JLabel tituloFormaDePago;
    private JLabel tituloBuscarVenta;
    private JTextField inputBuscarCodigoVenta;
    private JTextField inputAddCarroModelo;
    private JButton botonCrearVenta;
    private JButton botonBuscarVenta;
    private JButton atrasButton;

    public Ventas() {
        setContentPane(Ventas);
        setTitle("Ventas");
        setSize(960, 540);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Botones.focus(inputAddCliente, "Cedula Cliente");
        Botones.focus(inputAddVendedor, "Cedula Vendedor");
        Botones.focus(inputBuscarCodigoVenta, "Codigo");
        Botones.focus(inputAddCarroModelo, "Modelo");
        Botones.focus(inputAddCarroMarca, "Marca");

        atrasButton.addActionListener(e -> {
            new Interfaz();
            dispose();
        });
        botonCrearVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                    System.out.println(inputAddCliente.getText());

                    if(inputAddCliente.getText().equals("Cedula Cliente") ||
                            inputAddVendedor.getText().equals("Cedula Vendedor")||
                            inputAddCarroModelo.getText().equals("Modelo")||
                            inputAddCarroMarca.getText().equals("Marca")
                    ){
                        JOptionPane.showMessageDialog(null, "Campos vacios",
                                "Añadir empleado", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{


                        int posicionCliente=Almacen.buscarCliente(inputAddCliente.getText());
                        int posicionEmpleado=Almacen.buscarEmpleado(inputAddVendedor.getText());
                        int carroPos=Almacen.buscarCarro(inputAddCarroMarca.getText(),inputAddCarroModelo.getText());
                        if (carroPos==-1||posicionCliente==-1||posicionEmpleado==-1){
                            JOptionPane.showMessageDialog(null, "Faltan datos",
                                    "Añadir usuario", JOptionPane.ERROR_MESSAGE);
                        }else{
                            Cliente c1=Almacen.getClientes()[posicionCliente];
                            Vendedor v1=(Vendedor)Almacen.getEmpleados()[posicionEmpleado];
                            Carro carro=Almacen.getCarros()[carroPos];
                            String formaPago=inputAddFormaDePAgo.getSelectedItem().toString();


                            switch (formaPago){
                                case "Crédito":
                                    Almacen.addVenta(v1,c1,carro, LocalDate.now(),MP.CREDITO);
                                    break;
                                case "Transferencia Bancaria":
                                    Almacen.addVenta(v1,c1,carro, LocalDate.now(),MP.DEBITO);
                                    break;
                                case "Efectivo":
                                    Almacen.addVenta(v1,c1,carro,LocalDate.now(),MP.EFECTIVO);
                                    break;



                        }
                        int y=Almacen.getClientes()[posicionCliente].getVentasC().length-1;
                        Venta v= Almacen.getClientes()[posicionCliente].getVentasC()[y];

                            try {//Puse estp porque tira Unhandled Exception- Att, German.
                                JOptionPane.showMessageDialog(null, "Venta añadida"+v.getCodigo()+" "+v.calcularVenta(),
                                        "Añadir venta", JOptionPane.INFORMATION_MESSAGE);
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }


                        }

                            //Almacen.addVenta(inputNombreEmpleado.getText(), inputCcEmpleado.getText(),
                            //   inputTelefonoEmpleado.getText(), 0);//

                        }

                        //JOptionPane.showMessageDialog(null, Almacen.getCarros().length);

                }






        });


    }
}
