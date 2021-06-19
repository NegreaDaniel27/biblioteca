package dao;

import model.Autor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorDao {
    String connectionUrl = "jdbc:mysql://localhost:3306/biblioteca";
    private final String user = "root";
    private final String pasword = "Daniel";


    public Autor findById(int id) {
        Autor autor = new Autor();
        String query = "Select id, nume, prenume from autor where id = " + id;

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, pasword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                autor.setId(resultSet.getInt(1));
                autor.setNume(resultSet.getString(2));
                autor.setPrenume(resultSet.getString(3));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return autor;


    }


    public boolean save(Autor autor) {
        if (autor == null){
            return false;
        }


        String query = "insert into autor (nume, prenume) values (?, ?)";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, pasword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, autor.getNume());
            preparedStatement.setString(2, autor.getPrenume());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }return false;
    }

    public List<Autor> getAll (){
        List<Autor> autors = new ArrayList<>();
        String query = "select id, nume, prenume from autor";
        try{
            Connection connection = DriverManager.getConnection(connectionUrl, user, pasword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Autor autor = new Autor();
                autor.setId(resultSet.getInt("id"));
                autor.setNume(resultSet.getString("nume"));
                autor.setPrenume(resultSet.getString("prenume"));
                autors.add(autor);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return autors;
    }

    public void deleteById(int id){
        String query = "delete from autor where id = ?";

        try{
            Connection connection = DriverManager.getConnection(connectionUrl, user, pasword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);


            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

         } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }}
