package DAO;

import java.sql.SQLException;
import java.util.List;

import test.User;

public interface UserDAO {
    public void addUser(User user) throws SQLException;   
    public void updateUser(User user) throws SQLException;
    public User getUserById(int id) throws SQLException;    
    public List getAllUsers() throws SQLException;          
    public void deleteUser(User user) throws SQLException;
}