package com.lpu.otm;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Basic {
	public static void main(String[] args) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("dev");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		
		Account a1=new Account();
		a1.setId(1);
		a1.setName("Shubh");
		a1.setBalance(100);
		
		Account a2=new Account();
		a2.setId(2);
		a2.setName("Keshav");
		a2.setBalance(150);
		
		Bank b=new Bank();
		b.setId(10);
		b.setName("SBI");
		b.setLocation("Lucknow");
		
		List<Account> list=new ArrayList<Account>();
		list.add(a1);
		list.add(a2);
		
		b.setAccounts(list); //passing list
		
		et.begin();
		em.persist(a1);
		em.persist(a2);
		em.persist(b);
		et.commit();
	}
}