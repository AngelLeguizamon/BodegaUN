Es la ventana principal, una clase publica con nombre "Home" la cual extiende [[JFrame]], es decir que home es una clase de tipo [[JFrame]]

 ```java
 public class Home extends JFrame {}
``` 
## Se inicializa un objeto [[JPanel]] con nombre "listPanel" privado

```java
	private JPanel listPanel;
```
Este panel lo usaremos mas adelante
## Se declara el método constructor que se ejecuta cuando creamos un objeto [[Home]]                                                           

```java
	public Home() { ... }
```

- Se inicializa un  [[JPanel]] "topPanel" 
	- Se crea un [[JButton]] "Agregar Producto"  con un listener que al darle click crea un objeto [[AddProductFrame]]
	
``` JAVA
btnAgregarProducto.addActionListener(e -> {
    new AddProductFrame(this);
    });
```

- Se crea un objeto [[JPanel]] "mainPanel" con atributo un objeto tipo [[BorderLayout]] vacio
	- Se agrega el top "topPanel" en posición superior 
	- Se crea un objeto "listPanel" para mostrar la lista de productos y se le agrega un [[BoxLayout]] y [[JScrollPane]]
	- Finalmente llamamos al método #refreshProductList de [[Home]]

```java
	listPanel = new JPanel();
    listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
    JScrollPane scrollPane = new JScrollPane(listPanel);
    mainPanel.add(scrollPane, BorderLayout.CENTER);
```


## #refreshProductList El método muestra cada producto en un [[JLabel]] utilizando el método #readProducts de la clase [[ProductCRUD]] y se agregan botones que crean objetos [[UpdateProductFrame]] y [[DeleteProductFrame]] 

Este método se encarga de actualizar la lista de productos en **segundo plano** 
```java
    public void refreshProductList() { ... }
```

- Utilizamos un objeto [[SwingWorker]] para hacer el trabajo en un hilo paralelo al hilo de eventos inicial. Para que la lista se pueda actualizar sin detener el otro código que este corriendo.
``` java
        new SwingWorker<List<Producto>, Void>() { ... }
```

-  Utilizando el método abstracto #doInBackground se llama al método #readProducts de la clase [[ProductCRUD]], 
```java
@Override
    protected List<Producto> doInBackground() throws Exception {
        return ProductCRUD.readProducts();
```

```java
    listPanel.removeAll();  // Limpiamos el panel "listPanel"
```
- Una vez que se han leido los objetos tipo [[Producto]], se limpia la lista anterior  y se crea un panel para cada producto. utilizando el método abstracto #done de la clase [[SwingWorker]]

    - Cada producto se muestra con un [[JLabel]] que muestra en pantalla los atributos "nombre" "precio" y "cantidad"
    
    - Además, se crean dos [[JButton]]: 
	    - uno para **eliminar** que crea un objeto [[DeleteProductFrame]] 
	    - y otro para **actualizar** que crea un objeto [[UpdateProductFrame]]