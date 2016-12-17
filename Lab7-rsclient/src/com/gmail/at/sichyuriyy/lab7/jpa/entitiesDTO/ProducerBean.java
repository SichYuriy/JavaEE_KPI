package com.gmail.at.sichyuriyy.lab7.jpa.entitiesDTO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.gmail.at.sichyuriyy.lab7.entities.Producer;



@ManagedBean(name="producer")
@RequestScoped
public class ProducerBean {
	
	private long id;
	private String firstName;
	private String lastName;
	
	public ProducerBean() {
		
	}
	
	public ProducerBean(Producer p) {
		this.id = p.getId();
		this.firstName = p.getFirstName();
		this.lastName = p.getLastName();
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
