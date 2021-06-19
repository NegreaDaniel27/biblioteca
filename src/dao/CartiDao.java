package dao;

import model.Autor;
import model.Carti;
import model.Genuri;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartiDao {
    String connectionUrl = "jdbc:mysql://localhost:3306/biblioteca";
    private final String user = "root";
    private final String pasword = "Daniel";


    public Carti findById (int id){
        Carti carti = new Carti();
        String query = "select c.id, c.denumire, c.editura, c.an_aparitie, a.id, a.nume, a.prenume, g.id, g.denumire\n" +
                "from carti c \n" +
                "inner join autor a on c.id_auto = a.id\n" +
                "inner join genuri g  on c.id_gen = g.id\n" +
                "where c.id=?";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, pasword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                carti.setId(resultSet.getInt("c.id"));
                carti.setDenumire(resultSet.getString("c.denumire"));
                carti.setEditura(resultSet.getString("c.editura"));
                carti.setAnAparitie(resultSet.getString("c.an_aparitie"));

                Autor autor = new Autor();
                autor.setId(resultSet.getInt("a.id"));
                autor.setNume(resultSet.getString("a.nume"));
                autor.setPrenume(resultSet.getString("a.prenume"));
                carti.setAutor(autor);

                Genuri genuri = new Genuri();
                genuri.setId(resultSet.getInt("g.id"));
                genuri.setDenumire(resultSet.getString("g.denumire"));
                carti.setGenuri(genuri);

            }
        }catch (SQLException trowables){
            trowables.printStackTrace();
        }
        return carti;
    }

    public void save (Carti carti) {
        String query = "insert into carti (denumire, editura, an_aparitie, id_auto, id_gen) values (?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, pasword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, carti.getDenumire());
            preparedStatement.setString(2, carti.getEditura());
            preparedStatement.setString(3, carti.getAnAparitie());
            preparedStatement.setInt(4, carti.getAutor().getId());
            preparedStatement.setInt(5, carti.getGenuri().getId());


            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Carti> getAll (){
        List<Carti> cartis = new ArrayList<>();
        String query = "select c.id, c.denumire, c.editura, c.an_aparitie, a.id, a.nume, a.prenume, g.id, g.denumire\n" +
                "from carti c \n" +
                "inner join autor a on c.id_auto = a.id\n" +
                "inner join genuri g  on c.id_gen = g.id;";
        try{
            Connection connection = DriverManager.getConnection(connectionUrl, user, pasword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Carti carti = new Carti();
                carti.setId(resultSet.getInt("c.id"));
                carti.setDenumire(resultSet.getString("c.denumire"));
                carti.setEditura(resultSet.getString("c.editura"));
                carti.setAnAparitie(resultSet.getString("c.an_aparitie"));
                cartis.add(carti);

                Autor autor = new Autor();
                autor.setId(resultSet.getInt("a.id"));
                autor.setNume(resultSet.getString("a.nume"));
                autor.setPrenume(resultSet.getString("a.prenume"));
                carti.setAutor(autor);

                Genuri genuri = new Genuri();
                genuri.setId(resultSet.getInt("g.id"));
                genuri.setDenumire(resultSet.getString("g.denumire"));
                carti.setGenuri(genuri);

                cartis.add(carti);


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cartis;
    }
    public void deleteById(int id){
        String query = "delete from carti where id = ?";

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
