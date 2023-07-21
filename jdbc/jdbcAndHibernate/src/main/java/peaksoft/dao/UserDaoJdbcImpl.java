package peaksoft.dao;

import peaksoft.model.User;
import peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String sql = "create table if not exists users("+
                "id serial primary key,"+
                "name varchar,"+
                "last_name varchar,"+
                "age smallint )";

        try(Connection connection = Util.getConnection();
            Statement statement = connection.createStatement()){

            statement.executeUpdate(sql);
            System.out.println("Created table!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }




    }

    public void dropUsersTable() {
        String sql = "drop table users";
        try(Connection connection=Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }


    public void saveUser(String name, String lastName, byte age) {
        String sql = "insert into users("+
                "name,last_Name,age)"+
                "values(?,?,?)";

        try(Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,name);
            preparedStatement.setString(2,lastName);
            preparedStatement.setInt(3,age);

            preparedStatement.executeUpdate();
            System.out.println("New user saved!");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }

    public void removeUserById(long id) {
        String sql = "delete from users where id=?";
        try(Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);


            preparedStatement.executeUpdate();
            System.out.println("Is successfully deleted!"+id);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }


    public List<User> getAllUsers() {
        List<User>users = new ArrayList<>();
        String sql = "select * from users";
        try(Connection connection = Util.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet resultSet =statement.executeQuery(sql);
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("last_name"),
                        resultSet.getByte("age")));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return users;
    }

    public void cleanUsersTable() {
        String sql = "delete from users";
        try(Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}