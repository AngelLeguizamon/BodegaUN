1. Se reciben como parámetros objetos tipo [[Producto]] y tipo [[Home]] 
2. Se extiende un [[JFrame]] 
3. Se crean y agregan los elementos dentro de un [[JPanel]] tipo [[GridLayout]]

### Se configura el listener del [[JButton]] "btnAceptar"

- Se convierten los datos tipo [[double]] e [[int]] a tipo [[String]] 
- En caso de estar mal el formato, se solicitan nuevamente con un [[JOptionPane]]
- Se crea un [[Producto]] "updatedProducto" con los atributos obtenidos
### Se llama el método #updateProduct de [[ProductCRUD]]

### Se llama el método #refreshProductList de [[Home]]