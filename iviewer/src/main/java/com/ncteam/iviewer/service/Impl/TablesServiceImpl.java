package com.ncteam.iviewer.service.Impl;

import java.util.List;

import com.ncteam.iviewer.DAO.Impl.TablesDAOImpl;
import com.ncteam.iviewer.service.TablesService;


public class TablesServiceImpl<T extends TablesDAOImpl> implements TablesService{

	private T tablesDAO;
	
	public TablesServiceImpl(){	}
	
	public void setDAO(T dao){
		this.tablesDAO=dao;
	}

	public <T> void addRecord(T record) {
		tablesDAO.addRecord(record);		
	}


	public <T>void updateRecord(T record) {
		tablesDAO.updateRecord(record);
		
	}


	public <T> T getRecordById(int id, Class<T> classType) {
		return (T) tablesDAO.getRecordById(id, classType);
	}


	public <T>List<T> getAllRecords(Class<T> classType) {
		return tablesDAO.getAllRecords(classType);
	}


	public <T> void deleteRecord(Object record) {
		tablesDAO.deleteRecord(record);
		
	}

}
