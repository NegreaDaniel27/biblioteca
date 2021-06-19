package dao;

import model.Clienti;

import java.sql.*;

public class ClientiDao {
    String connectionUrl = "jdbc:mysql://localhost:3306/biblioteca";
    private final String user = "root";
    private final String pasword = "Daniel";


    public Clienti findById(int id) {
        Clienti clienti = new Clienti();
        String query = "Select id, nume, prenume, telefon, email, adresa from Clienti where id = " + id;

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, pasword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                clienti.setId(resultSet.getInt(1));
                clienti.setNume(resultSet.getString(2));
                clienti.setPrenume(resultSet.getString(3));
                clienti.setTelefon(resultSet.getString(4));
                clienti.setEmail(resultSet.getString(5));
                clienti.setAdresa(resultSet.getString(6));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return clienti;


    }


    public void save(Clienti clienti) {
        String query = "insert into Clienti (nume, prenume, telefon, email, adresa) values (?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, pasword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, clienti.getNume());
            preparedStatement.setString(2, clienti.getPrenume());
            preparedStatement.setString(3, clienti.getTelefon());
            preparedStatement.setString(4, clienti.getEmail());
            preparedStatement.setString(5, clienti.getAdresa());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteById(int id){
        String query = "delete from clienti where id = ?";

        try{
            Connection connection = DriverManager.getConnection(connectionUrl, user, pasword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}
