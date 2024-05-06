package dal;

import entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDBContext extends DBContext<User> {

    @Override
    public ArrayList<User> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(User entity) {
        String sql = "INSERT INTO Users (UserName, Password, RoleName) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, entity.getUserName());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getRoleName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User get(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public User login(String username, String password) {
        User user = null;
        String sql = "SELECT UserId, UserName, Password, RoleName FROM Users WHERE UserName = ? AND Password = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("UserId");
                String userName = resultSet.getString("UserName");
                String userPassword = resultSet.getString("Password");
                String roleName = resultSet.getString("RoleName");

                user = new User(userId, userName, userPassword, roleName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User getUserByUsername(String username) {
        User user = null;
        String sql = "SELECT UserId, UserName, Password, RoleName FROM Users WHERE UserName = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("UserId");
                String userName = resultSet.getString("UserName");
                String userPassword = resultSet.getString("Password");
                String roleName = resultSet.getString("RoleName");

                user = new User(userId, userName, userPassword, roleName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
