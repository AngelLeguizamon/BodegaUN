## #createProduct

Como parámetro se recibe un objeto de tipo [[Producto]] con nombre "producto"
```java
    public static void createProduct(Producto producto) {
```

- Con el método #databaseRef de la clase [[DatabaseReference]]  se crea la referencia de la base de datos que se va a utilizar. Es la raíz en la base de datos desde la que se va a trabajar, a esta raíz la llamamos "newProductRef"
	 utilizando .child se crea un nodo con nombre "productos" 
	 finalmente se usa .push para subir 

- Ce utiliza .getKey() como argumento del método #setID de la clase [[Producto]] para guardar un ID único generado por la base de datos
``` java
	producto.setID(newProductRef.getKey());
```

- Se instancia un objeto [[core.ApiFuture]] con nombre "furure" para que guarde al objeto [[Producto]] de manera asíncrona en la base de datos, 
	así el programa puede seguir corriendo sin esperar a que se realice esta acción.
```java
	ApiFuture<void> future = newProductRef.setValueAsync(producto);
```

- Finalmente se verifica que el producto si cargo correctamente por medio de un try y un .get
``` java
try {
    future.get();
    System.out.println("¡Producto creado correctamente!");
} catch (InterruptedException | ExecutionException e) {
    System.out.println("Error al crear el producto: " + e.getMessage());
}
```




## #readProducts 

1. Se inicializa una [[List]] "producto" vacía para guardar lo obtenido de la base de datos
2. Se inicia una conexión o referencia "ref" que identifica el nodo "productos" 
3. Se crea un objeto [[CountDownLatch]] "latch" (en si es un cronometro)

### Se lee cada ítem dentro del nodo de la base de datos

este proceso se hace dentro de [[@overide]]
#onDataChange recorre cada ítem (cada producto) de la rama "productos". 

- Se convierte cada fragmento de datos en un objeto [[Producto]]
- Se asigna al producto su "ID" único usando la clave del nodo.
- Se añade el producto a la lista "producto"
- Al terminar, se llama a `latch.countDown()` para indicar que la lectura ha finalizado.
### Se espera a que se terminen de leer los datos
utilizando `latch.await();`  dentro de un try

### Se ordena la lista

Usando el método #sort de la clase [[Collections]] se ordena la lista "producto" o "productos" no estoy seguro, segun el atributo nombre de cada ítem

### Se retorna una lista ordenada


## #updateProduct

1. Recibe de atributos un string "id" y un [[Producto]] "updatedProducto"
2. Se inicia una conexión o referencia "ref" que identifica el nodo "productos" 
3. A "updatedProducto" se le guarda el "id"
4. Se utiliza [[core.ApiFuture]] para guardar "updatedProducto" en el nodo 

## #deleteProduct

1. Recibe de atributos un string "id" 
2. Se inicia una conexión o referencia "ref" que identifica el nodo "productos" 
3. Se utiliza [[core.ApiFuture]] para eliminar el .child("id") del nodo especificado