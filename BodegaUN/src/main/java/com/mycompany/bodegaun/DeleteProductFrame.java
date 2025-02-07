package com.mycompany.bodegaun;

import javax.swing.*;
import java.awt.*;

public class DeleteProductFrame extends JFrame {
    public DeleteProductFrame(String productId, Home home) {
        setTitle("Eliminar Producto");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Panel con mensaje de confirmación y botón "Aceptar"
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        JLabel label = new JLabel("¿Estás seguro? Esta acción no se puede revertir.");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);
        JButton btnAceptar = new JButton("Aceptar");
        panel.add(btnAceptar, BorderLayout.SOUTH);
        
        // Al presionar "Aceptar" se elimina el producto y se refresca la lista
        btnAceptar.addActionListener(e -> {
            ProductCRUD.deleteProduct(productId);
            JOptionPane.showMessageDialog(null, "Producto eliminado.");
            home.refreshProductList();
            dispose();
        });
        
        add(panel);
        setVisible(true);
    }
}
