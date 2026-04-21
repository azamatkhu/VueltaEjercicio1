# Vuelta Ciclista: Ejercicio 1

**Escribir Implementa un programa Java que:**
**1. Se conecte a la base de datos XE donde se encuentre el esquema de la Vuelta Ciclista usando JDBC (URL, usuario, contraseña).**
**2. Muestre por consola todos los ciclistas con este formato: id_ciclista - nombre - nacionalidad - edad - nombre_equipo.**
**3. Permita filtrar por país del equipo: que el usuario introduzca un país (por ejemplo “España”) y se listen solo los ciclistas cuyos equipos sean de ese país.**

El programa primero conecta a base de datos con el esquema de la Vuelta Ciclista.
Luego hace primera consulta, para mostrar por consola los ciclistas con el formato. Utilizamos un ResultSet para recorrer y mostrar los datos.
Y por ultimo, otra consulta con WHERE EQUIPO.PAIS = ?, para filtrar por pais del equipo los ciclistas. Tambien se utiliza un ResultSet para mostrar estos ciclistas.
