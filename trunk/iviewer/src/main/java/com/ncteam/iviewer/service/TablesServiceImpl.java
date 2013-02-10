package com.ncteam.iviewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncteam.iviewer.DAO.TablesDAO;
import com.ncteam.iviewer.service.TablesService;

@Service
public class TablesServiceImpl implements TablesService{

	@Autowired
	private TablesDAO tablesDAO;
	
	public void setTablesDAO(TablesDAO tablesDAO){
		this.tablesDAO=tablesDAO;
	}
	
	@Transactional
	public <T> void addRecord(T record) {
		tablesDAO.addRecord(record);		
	}

	@Transactional
	public <T>void updateRecord(T record) {
		tablesDAO.updateRecord(record);
		
	}

	@Transactional
	public <T> T getRecordById(int id, Class<T> classType) {
		return (T) tablesDAO.getRecordById(id, classType);
	}

	@Transactional
	public <T>List<T> getAllRecords(Class<T> classType) {
		return tablesDAO.getAllRecords(classType);
	}

	@Transactional
	public <T> void deleteRecord(Object record) {
		tablesDAO.deleteRecord(record);
		
	}

}
