package by.it_academy.jd2.Mk_JD2_90_22.aviasales.main;

import java.sql.*;
import java.util.Scanner;

//1'; INSERT INTO bookings.airports_data(airport_code, airport_name, city, coordinates, timezone) VALUES ('666', '{"en" : "Evil Stantion", "ru" : "Станция Сатаны"}', '{"en" : "Evil Home", "ru" : "Дом Сатаны"}', '(61.5033,55.305801)', '' );SELECT airport_code, airport_name, city, coordinates, timezone FROM bookings.airports WHERE airport_code = '666
public class Main5 {

    private static  final String QUERY = "SELECT\n" +
            "    airport_code,\n" +
            "    airport_name,\n" +
            "    city,\n" +
            "    coordinates,\n" +
            "    timezone\n" +
            "FROM\n" +
            "    bookings.airports\n" +
            "WHERE airport_code = ?;";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Проверь имя драйвера!!!!", e);
        }

        Scanner console = new Scanner(System.in);

        System.out.println("Введите код аэропорта");
        String code = console.nextLine();

        try (Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/demo",
                    "postgres",
                    "postgres"
            );
             PreparedStatement statement = connection.prepareStatement(QUERY);
        ) {
            statement.setString(1, code);
            try(ResultSet resultSet = statement.executeQuery();){
                while (resultSet.next()){
                    System.out.println(resultSet.getString("airport_name"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
