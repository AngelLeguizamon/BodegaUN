package com.mycompany.bodegaun;

import javax.swing.*;
import java.awt.*;

public class UpdateProductFrame extends JFrame {
    public UpdateProductFrame(Producto producto, Home home) {
        setTitle("Actualizar Producto");
        setSize(300, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField(producto.getNombre());
        JLabel lblPrecio = new JLabel("Precio:");
        JTextField txtPrecio = new JTextField(String.valueOf(producto.getPrecio()));
        JLabel lblCantidad = new JLabel("Cantidad:");
        JTextField txtCantidad = new JTextField(String.valueOf(producto.getCantidad()));
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblPrecio);
        panel.add(txtPrecio);
        panel.add(lblCantidad);
        panel.add(txtCantidad);
        panel.add(new JLabel("")); // Celda vacía para diseño
        JButton btnAceptar = new JButton("Aceptar");
        panel.add(btnAceptar);
        
        // Al presionar "Aceptar" se actualiza el producto
        btnAceptar.addActionListener(e -> {
            String nombre = txtNombre.getText();
            double precio;
            int cantidad;
            try {
                precio = Double.parseDouble(txtPrecio.getText());
                cantidad = Integer.parseInt(txtCantidad.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ingresa valores numéricos válidos para precio y cantidad.");
                return;
            }
            Producto updatedProducto = new Producto(nombre, precio, cantidad);
            ProductCRUD.updateProduct(producto.getId(), updatedProducto);
            JOptionPane.showMessageDialog(null, "Producto actualizado.");
            home.refreshProductList();
            dispose();
        });
        
        add(panel);
        setVisible(true);
    }
}
