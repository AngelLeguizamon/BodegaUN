package view;

import com.mycompany.bodegaun.ProductCRUD;
import com.mycompany.bodegaun.Producto;
import javax.swing.*;
import java.awt.*;

public class AddProductFrame extends JFrame {
    public AddProductFrame(Home home) {
        setTitle("Agregar Producto");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //Se crea un panel compuesto por una tabla de cuatro filas y dos columnas.  
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        
        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField();
        
        JLabel lblCantidad = new JLabel("Cantidad:");
        JTextField txtCantidad = new JTextField();
        
        JButton btnAceptar = new JButton("Aceptar"); 
        
        // Se agregans los elementos al panel en la pocision deseada
        panel.add(lblNombre);     // Fila 1 Columna 1
        panel.add(txtNombre);     // Fila 1 Columna 2
        panel.add(lblPrecio);     // Fila 2 Columna 1
        panel.add(txtPrecio);     // Fila 2 Columna 2
        panel.add(lblCantidad);   // Fila 3 Columna 1
        panel.add(txtCantidad);   // Fila 3 Columna 2
        panel.add(new JLabel(""));// Fila 4 Columna 1 celda vacia
        panel.add(btnAceptar);    // Fila 4 Columna 2
        
        // Acción al presionar "Aceptar"
        btnAceptar.addActionListener(e -> {
            
            // Se declaran variables para pasar (Double e Integer) a (String)
            String precioStr = txtPrecio.getText();
            String cantidadStr = txtCantidad.getText();
            
            // Se declaran las variables para agregar a los atributos de "Producto"
            String nombre = txtNombre.getText();   // nombre
            double precio;                         // precio
            int cantidad;                          // cantidad 
            try {
                precio = Double.parseDouble(precioStr);
                cantidad = Integer.parseInt(cantidadStr);
            } catch (NumberFormatException ex) {
                
                //Mensaje al no poner un valor numerico en (Precio o Cantidad)
                JOptionPane.showMessageDialog(null, "Ingresa valores numéricos válidos para precio y cantidad.");
                return;
            }
            
            // Se instancia un objeto "Producto" con atributos (nombre, precio, cantidad)
            Producto nuevoProducto = new Producto(nombre, precio, cantidad);
            ProductCRUD.createProduct(nuevoProducto); //Metodo "createProduct" del CRUD
            
            // Mensaje de exito
            JOptionPane.showMessageDialog(null, "Producto agregado exitosamente!");
            
            // Se actualiza la lista en "Home"
            home.refreshProductList(); 
            
            //Se cierra la ventana
            dispose();        
        });
        
        
        add(panel);
        setVisible(true);
    }
}
