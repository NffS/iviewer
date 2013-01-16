package DAO;

import java.sql.SQLException;
import java.util.List;

import test.Form;

public interface FormDAO {

	 public void addForm(Form form) throws SQLException;   
	 public void updateForm(Form form) throws SQLException;
	 public Form getFormById(int id) throws SQLException;    
	 public List getAllForms() throws SQLException;          
	 public void deleteForm(Form form) throws SQLException;
}
