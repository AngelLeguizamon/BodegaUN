## Atributos
- "id"              de tipo [[String]], lo genera (firebase)
- "nombre"    de tipo [[String]]
- "precio"       de tipo decimal, [[double]]
- "cantidad"   de tipo entero [[int]]

## #Producto para firebase
Se crea un constructor vacío para que "firebase" lo utilice

## #Producto 
Se crea un constructor para crear un objeto tipo [[Producto]]

## Métodos get y set 
Se crean los métodos para poder acceder a los atributos privados

```java
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
```

#SetID