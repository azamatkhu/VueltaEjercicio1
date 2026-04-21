import java.sql.*;
import java.util.*;

public class MainVueltaEjercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "RIBERA",
                    "ribera"
            );

            System.out.println("Conectado!");

            Statement statement = connection.createStatement();

            // Una sql para sacar las ciclistas
            String sql = "SELECT ID_CICLISTA, CICLISTA.NOMBRE, NACIONALIDAD, EDAD, EQUIPO.NOMBRE AS NOMBRE_EQUIPO FROM CICLISTA JOIN EQUIPO USING(ID_EQUIPO)";
            ResultSet resultSet = statement.executeQuery(sql);

            // Un resultset para recorrer los datos y mostrarlos
            while (resultSet.next()) {
                int id = resultSet.getInt("ID_CICLISTA");
                String nombre = resultSet.getString("NOMBRE");
                String nacionalidad = resultSet.getString("NACIONALIDAD");
                int edad = resultSet.getInt("EDAD");
                String nombreEquipo =  resultSet.getString("NOMBRE_EQUIPO");
                System.out.println(id + " - " + nombre + " - " + nacionalidad + " - " + edad + " - " + nombreEquipo);
            }

            // Preguntas que de pais quieremos sacar las ciclistas
            System.out.println("De que pais quieres sacar las ciclistas: ");
            String pais = sc.nextLine();
            
            // Una sql para sacar las ciclistas con esa pais
            String sql2 = "SELECT ID_CICLISTA, CICLISTA.NOMBRE, NACIONALIDAD, EDAD, EQUIPO.NOMBRE AS NOMBRE_EQUIPO FROM CICLISTA JOIN EQUIPO USING(ID_EQUIPO) WHERE EQUIPO.PAIS = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setString(1,pais);

            ResultSet resultSet2 = preparedStatement.executeQuery();

            // Un resultset2 para recorrer los datos y mostrarlos
            while (resultSet2.next()) {
                int id = resultSet2.getInt("ID_CICLISTA");
                String nombre = resultSet2.getString("NOMBRE");
                String nacionalidad = resultSet2.getString("NACIONALIDAD");
                int edad = resultSet2.getInt("EDAD");
                String nombreEquipo =  resultSet2.getString("NOMBRE_EQUIPO");
                System.out.println(id + " - " + nombre + " - " + nacionalidad + " - " + edad + " - " + nombreEquipo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
