package com.ncteam.iviewer.service.Impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncteam.iviewer.DAO.Impl.NewsDAOImpl;

@Service
public class NewsServiceImpl extends TablesServiceImpl<NewsDAOImpl> {

	@Autowired
	private NewsDAOImpl newsDAO;
	
	public NewsServiceImpl(){
		super();
	}
	
	@PostConstruct
	private void init(){
		super.setDAO(newsDAO);
	}
}
