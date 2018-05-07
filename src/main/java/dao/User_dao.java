package dao;

import util.ConnectionConfiguration;
import entities.User;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User_dao {
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
                person.setFirstName(resultSet.getString("first_name"));
                person.setLastName(resultSet.getString("last_name"));

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
            preparedStatement = connection.prepareStatement("INSERT INTO person (first_name,last_name)" +
                    "VALUES (?, ?)");
            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO person (first_name,last_name)" +
                    "VALUES (?, ?)");
            preparedStatement.execute("CREATE TABLE IF NOT EXISTS person (id int primary key unique auto_increment," +
                    "first_name varchar(55), last_name varchar(55))");
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
            preparedStatement = connection.prepareStatement("SELECT person_id, first_name, last_name FROM person WHERE first_name = ?");
            preparedStatement.setString(1, person.getFirstName());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                person1.setId(resultSet.getInt("person_id"));
                person1.setFirstName(resultSet.getString("first_name"));
                person1.setLastName(resultSet.getString("last_name"));

            }
            if(person.getLastName().equals(person1.getLastName())) {
                System.out.println("true");
                return true;
            }
            System.out.println("false");
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