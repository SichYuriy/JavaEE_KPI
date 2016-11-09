package com.gmail.at.sichyuriyy.lab4.jpa.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingleEntityManagerFactory {
	
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getInstace() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("Lab4");
		}
		return factory;
	}

}
