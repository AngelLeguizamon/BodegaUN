package view;

import com.mycompany.bodegaun.ProductCRUD;
import com.mycompany.bodegaun.Producto;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Home extends JFrame {
    
    private JPanel listPanel;
    
    public Home() {
        setTitle("Bodega UN / Home");
        setSize(900, 600); 
        // Indicamos que al dar en la "X" se cierre el programa                   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
        // Lo centramos en la pantalla
        setLocationRelativeTo(null);                         
        
        // Panel principal con BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        
        // Panel superior con el botón "Agregar Producto"
        JPanel topPanel = new JPanel();
        JButton btnAgregarProducto = new JButton("Agregar Producto");

        
        // Al presionar, se abre la ventana para agregar un producto
        btnAgregarProducto.addActionListener(e -> {
            new AddProductFrame(this);
        });
        
        topPanel.add(btnAgregarProducto);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        
        // Panel central para mostrar la lista de productos
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(listPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        
        add(mainPanel);
        setVisible(true);
        
        // Carga la lista de productos sin bloquear el EDT ???
        refreshProductList();
    } 
    
    // Este método recarga la lista de productos desde Firebase usando un SwingWorker
    public void refreshProductList() {
        
        // Se crea un objeto tipo SwingWorker para hacer tareas en segundo plano sin detener el otro codigo ejecutado.
        new SwingWorker<List<Producto>, Void>() {
            @Override
            protected List<Producto> doInBackground() throws Exception {
                // Esta operación se ejecuta en un hilo de fondo
                return ProductCRUD.readProducts();
            }
            
            @Override
            protected void done() {
                try {
                    List<Producto> productos = get();
                    listPanel.removeAll();  // Limpiamos el panel
                    
                    for (Producto p : productos) {
                        JPanel productPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        JLabel label = new JLabel(" - Nombre: " + p.getNombre() +
                                                  " - Precio: " + p.getPrecio() + " - Cantidad: " + p.getCantidad());
                        productPanel.add(label);
                        
                        // Botón para eliminar el producto
                        JButton btnEliminar = new JButton("Eliminar");
                        btnEliminar.addActionListener(e -> {
                            new DeleteProductFrame(p.getId(), Home.this);
                        });
                        productPanel.add(btnEliminar);
                        
                        // Botón para actualizar el producto
                        JButton btnActualizar = new JButton("Actualizar");
                        btnActualizar.addActionListener(e -> {
                            new UpdateProductFrame(p, Home.this);
                        });
                        productPanel.add(btnActualizar);
                        
                        listPanel.add(productPanel);
                    }
                    listPanel.revalidate();
                    listPanel.repaint();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }.execute();
    }
}
