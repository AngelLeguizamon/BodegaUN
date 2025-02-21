
Se crea un [[JFrame]] proveniente del paquete javax\swing

- Se crea un [[JPanel]] con un [[GridLayout]] 3x2, una disposición como una tabla
	- Se crea un [[JLabel]] con el texto "Usuario:" o el texto que se quiera mostrar
	- Se crea un [[JTextField]] un espacio para que se escriba texto
	- Se crea un [[JPasswordField]] un espacio para que se escriba texto sin mostrarse en pantalla
	- Se crea un [[JButton]] 


- Se agrega un #ActionListener al Botón creado para que al darle click
	- Se guarde en una variable "usuario" el texto ingresado
	- Se guarde en una variable "password" la contraseña ingresada
	- Se comparan los valores de las variables con el método #equals de la clase [[Object]]


En caso de exito: usuario == usuarioPredeterminado && password == contraseñaPredeterminada
	- Se crea un [[JOptionPane]] una ventana de alerta con texto "Acceso concedido."
	- Se crea un objeto [[Home]]

