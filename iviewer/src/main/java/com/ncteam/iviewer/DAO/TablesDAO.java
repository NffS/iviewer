package com.ncteam.iviewer.DAO;

import java.util.List;

public interface TablesDAO {
	public <T> void addRecord(T record);   
    public <T> void updateRecord(T record);
    public <T> T getRecordById(int id, Class<T> classType);    
    public <T> List<T> getAllRecords(Class<T> classType);          
    public void deleteRecord(Object record);
}
