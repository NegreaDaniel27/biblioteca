package dao;



import model.Imprumut;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImprumutDao {
    String connectionUrl = "jdbc:mysql://localhost:3306/biblioteca";
    private final String user = "root";
    private final String pasword = "Daniel";


    public Imprumut findById(int id) {
        Imprumut imprumut = new Imprumut();
        String query = "Select id, dataImprumut, dataRetur from imprumut where id = " + id;

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, pasword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                imprumut.setId(resultSet.getInt(1));
                imprumut.setDataImprumut(resultSet.getString(4));
                imprumut.setDataReturn(resultSet.getString(5));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return imprumut;

    }

    public List<Imprumut> getAll (){
        List<Imprumut> imprumuts = new ArrayList<>();
        String query = "select * from imprumut";
        try{
            Connection connection = DriverManager.getConnection(connectionUrl, user, pasword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Imprumut imprumut = new Imprumut();
                imprumut.setId(resultSet.getInt(1));
                imprumut.setDataImprumut(resultSet.getString(2));
                imprumut.setDataReturn(resultSet.getString(3));


                imprumuts.add(imprumut);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return imprumuts;
    }
    

    public void save (Imprumut imprumut) {
        String query = "insert into imprumut (dataImprumut, dataRetur) values (?, ?)";

        try {
            Connection connection = DriverManager.getConnection(connectionUrl, user, pasword);
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(2, imprumut.getDataImprumut());
            preparedStatement.setString(4, imprumut.getDataReturn());


            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
