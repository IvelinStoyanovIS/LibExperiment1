package dao;

import util.ConnectionConfiguration;
import entities.User;

import java.math.BigInteger;
import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User_dao {

    public String hash(String pass) {
        MessageDigest md;
        byte[] hash = null;
        try {
            md = MessageDigest.getInstance("MD5");
            hash = md.digest(pass.getBytes("UTF-8"));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return DatatypeConverter.printHexBinary(hash);
    }


    public void createPersonTable() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS person (id int primary key unique auto_increment," +
                    "first_name varchar(55), last_name varchar(55))");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public List<User> selectAll() {
        List<User> persons = new ArrayList<User>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionConfiguration.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM person");

            while (resultSet.next()) {
                User person;
                person = new User();
                person.setId(resultSet.getInt("id"));
                person.setUserName(resultSet.getString("first_name"));
                person.setPassword(resultSet.getString("last_name"));

                persons.add(person);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return persons;
    }


    public void insert(User person) {
        //public void insert() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;



        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO person (user_name, password, role_id, hash_pass)" +
                    "VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, person.getUserName());
            preparedStatement.setString(2, person.getPassword());
            preparedStatement.setInt(3, 01);
            preparedStatement.setString(4, person.getHashedPassword());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO person (user_name,password, role_id, hash_pass)" +
                    "VALUES (?, ?)");
            //preparedStatement.execute("CREATE TABLE IF NOT EXISTS role (id INT AUTO_INCREMENT PRIMARY KEY,\n" +
            //        "    roleName VARCHAR(20) NOT NULL)");
            preparedStatement.execute("CREATE TABLE IF NOT EXISTS person (person_id int primary key unique auto_increment," +
                    "user_name varchar(55), password varchar(55), role_id INT,\n" +
                    "    hash_pass VARCHAR(100),\n" +
                    "    CONSTRAINT FOREIGN KEY (role_id) REFERENCES role (id))");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public boolean selectByUName(User person) {
        User person1 = new User();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = ConnectionConfiguration.getConnection();
            preparedStatement = connection.prepareStatement("SELECT person_id, user_name, password, hash_pass FROM person WHERE user_name = ?");
            preparedStatement.setString(1, person.getUserName());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                person1.setId(resultSet.getInt("person_id"));
                person1.setUserName(resultSet.getString("user_name"));
                person1.setPassword(resultSet.getString("password"));
                person1.setHashedPassword(resultSet.getString("hash_pass"));

            }

            if(person.getHashedPassword().equals(person1.getHashedPassword()))
            {
                return true;
            }
            return false;


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }

            }
        }

    }

}

