package com.lpu.otm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CrudAccount implements BankAccountCRUD {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();

	public static void main(String[] args) {
		CrudAccount bac = new CrudAccount();
		Bank b = new Bank();
		b.setId(201);
		b.setName("Central Bank of India");
		b.setLocation("New Delhi");

		Account a = new Account();
		a.setId(110);
		a.setName("ABC");
		a.setBalance(0);
		Account a1 = new Account();
		a1.setId(120);
		a1.setName("DEF");
		a1.setBalance(0);
		Account a2 = new Account();
		a2.setId(130);
		a2.setName("GHI");
		a2.setBalance(0);
		bac.saveBank(b);
		bac.updateBank(101, "Kotak Mahindra", "Faridabad");
		Bank b1 = bac.findBankById(101);
		System.out.println("ID: " + b1.getId() + ", Name: " + b1.getName() + ", Location: " + b1.getLocation());
		Bank b2 = bac.findBankByName("IDBI");
		System.out.println("ID: " + b2.getId() + ", Name: " + b2.getName() + ", Location: " + b2.getLocation());
		bac.assignAccountToBank(102, a);
		bac.assignAccountsToBank(201, new ArrayList<>(Arrays.asList(a1, a2)));
		for (Account acc : bac.findAllAccountsInBank(102)) {
			System.out.println("ID: " + acc.getId() + ", Name: " + acc.getName() + ", Balance: " + acc.getBalance());
		}

	}

	@Override
	public void saveBank(Bank bank) {
		et.begin();
		em.persist(bank);
		et.commit();
	}

	@Override
	public void updateBank(int id, String name, String location) {
		Bank b = em.find(Bank.class, id);
		et.begin();
		b.setName(name);
		b.setLocation(location);
		em.merge(b);
		et.commit();

	}

	@Override
	public Bank findBankById(int id) {
		Bank b = em.find(Bank.class, id);
		return b;
	}

	@Override
	public Bank findBankByName(String name) {

	
		return em.createQuery("SELECT b FROM Bank b WHERE b.name = :n", Bank.class).setParameter("n", name)
				.getSingleResult();

	}

	@Override
	public void assignAccountToBank(int bankId, Account newAccount) {
		
		et.begin();
		Bank b = em.find(Bank.class, bankId);
		b.setAccounts(new ArrayList<>(Arrays.asList(newAccount)));
		newAccount.setBank(b);
		em.merge(newAccount);
		em.merge(b);
		et.commit();
	}

	@Override
	public void assignAccountsToBank(int bankId, List<Account> accounts) {
		
		et.begin();
		Bank b = em.find(Bank.class, bankId);
		b.setAccounts(new ArrayList<>(accounts));
		for(Account a : accounts)
		{
			a.setBank(b);
			em.merge(a);
		}
		em.merge(b);
		et.commit();
	}

	@Override
	public List<Account> findAllAccountsInBank(int bankId) {
		Bank b = findBankById(bankId);
		return b.getAccounts();
	}

}