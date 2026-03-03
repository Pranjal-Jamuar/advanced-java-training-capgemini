package com.lpu;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		System.out.println(emf);

	}

}
