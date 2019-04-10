package com.gtm.jenkins.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gtm.jenkins.dao.IDao;
import com.gtm.jenkins.model.Client;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	IDao dao;
	
	public Client saveClient(Client client) {
		
		return this.dao.save(client);
	}
	
	public void deleteByName(String name) {
		
		this.dao.deleteByName(name);
	}
	
	public Client getByName(String name) {
		
		return this.dao.getByName(name);
	}
	
	public List<Client> getAll() {
		
		return this.dao.findAll();
	}
}
