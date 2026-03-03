package com.lpu.otm;

import java.util.List;

public interface BankAccountCRUD {
void saveBank(Bank bank);
void updateBank(int id, String name, String location);
Bank findBankById(int id);
Bank findBankByName(String name);
void assignAccountToBank(int bankId, Account newAccount);
void assignAccountsToBank(int bankId, List<Account> accounts);
List<Account> findAllAccountsInBank (int bankId);
}