package com.ncteam.iviewer.service;

import java.util.List;

public interface TablesService {
	public <T> void addRecord(T record);   
    public <T> void updateRecord(T record);
    public <T> T getRecordById(int id, Class<T> classType);    
    public <T> List<T> getAllRecords(Class<T> classType);          
    public <T >void deleteRecord(Object record);
}
