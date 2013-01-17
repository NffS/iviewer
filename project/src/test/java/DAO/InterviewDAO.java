package DAO;

import java.sql.SQLException;
import java.util.List;

import test.Interview;

public interface InterviewDAO {

	 public void addInterview(Interview interview) throws SQLException;   
	    public void updateInterview(Interview interview) throws SQLException;
	    public Interview getInterviewById(int id) throws SQLException;    
	    public List getAllInterview() throws SQLException;          
	    public void deleteInterview(Interview interview) throws SQLException;
}