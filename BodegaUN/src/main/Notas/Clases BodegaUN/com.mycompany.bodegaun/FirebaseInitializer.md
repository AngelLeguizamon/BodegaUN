Inicia la base de datos "**RealTime DataBase**" de Firebase

## #initialize 

- Usamos el método #serviceAccount de la clase [[FileInputStream]] para leer la clave [[firebase-service-account.json]] 

- Creamos un objeto tipo [[FirebaseOptions]]  para configurar la Base de datos 
	- #setCredentials  guardamos el archivo de clave leído anteriormente
	- #setDatabaseUrl guardamos la URL de la base datos propia

- Usamos el método #initializeApp de la clase [[FirebaseApp]] con atributo el objeto "**options**" usado anteriormente para inicializar Firebase