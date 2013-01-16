package DAO;

import java.sql.SQLException;
import java.util.List;

import test.Users_type;

public interface Users_typeDAO {

	 public void addUser_type(Users_type user_type) throws SQLException;   
	    public void updateUser_type(Users_type user_type) throws SQLException;
	    public Users_type getUser_typeById(int id) throws SQLException;    
	    public List getAllUser_types() throws SQLException;          
	    public void deleteUser_type(Users_type user_type) throws SQLException;
}
