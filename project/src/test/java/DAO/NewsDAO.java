package DAO;

import java.sql.SQLException;
import java.util.List;

import test.News;

public interface NewsDAO {
	
	public void addNews(News news) throws SQLException;   
    public void updateNews(News news) throws SQLException;
    public News getNewsById(int id) throws SQLException;    
    public List getAllNews() throws SQLException;          
    public void deleteNews(News news) throws SQLException;
    
}