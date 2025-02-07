package com.mycompany.bodegaun;

import javax.swing.*;
import java.awt.*;

public class AddProductFrame extends JFrame {
    public AddProductFrame(Home home) {
        setTitle("Agregar Producto");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        
        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField();
        
        JLabel lblCantidad = new JLabel("Cantidad:");
        JTextField txtCantidad = new JTextField();
        
        JButton btnAceptar = new JButton("Aceptar");
        
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblPrecio);
        panel.add(txtPrecio);
        panel.add(lblCantidad);
        panel.add(txtCantidad);
        panel.add(new JLabel("")); // Celda vacía para diseño
        panel.add(btnAceptar);
        
        // Acción al presionar "Aceptar"
        btnAceptar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            String precioStr = txtPrecio.getText();
            String cantidadStr = txtCantidad.getText();
            double precio;
            int cantidad;
            try {
                precio = Double.parseDouble(precioStr);
                cantidad = Integer.parseInt(cantidadStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingresa valores numéricos válidos para precio y cantidad.");
                return;
            }
            Producto nuevoProducto = new Producto(nombre, precio, cantidad);
            ProductCRUD.createProduct(nuevoProducto);
            JOptionPane.showMessageDialog(null, "Producto agregado exitosamente!");
            home.refreshProductList(); // Actualiza la lista en Home
            dispose();
        });
        
        add(panel);
        setVisible(true);
    }
}
