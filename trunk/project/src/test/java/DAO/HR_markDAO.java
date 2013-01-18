package DAO;

import java.sql.SQLException;
import java.util.List;

import test.HR_mark;;

public interface HR_markDAO {

	 public void addHR_mark(HR_mark hr_mark) throws SQLException;   
	    public void updateHR_mark(HR_mark hr_mark) throws SQLException;
	    public HR_mark getHR_markById(int id) throws SQLException;    
	    public List getAllHR_mark() throws SQLException;          
	    public void deleteHR_mark(HR_mark hr_mark) throws SQLException;
}