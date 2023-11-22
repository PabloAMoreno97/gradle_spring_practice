package com.lechuga_company.learning_gradle_project.service;

import com.lechuga_company.learning_gradle_project.model.Account;
import com.lechuga_company.learning_gradle_project.model.Person;
import com.lechuga_company.learning_gradle_project.repository.AccountRepository;
import com.lechuga_company.learning_gradle_project.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PersonRepository personRepository;

    public Account getAccount(Long personId){
        Person person = personRepository.findById(personId).orElse(null);
        if (person == null){
            return null;
        }
        List<Account> account = accountRepository.findByOwner(person);
        if (account.isEmpty()){
            return null;
        }
        return account.get(0);
    }

    public Account saveAccount(Long balance, Long personId){
        Person person = personRepository.findById(personId).orElse(null);
        if (person==null){
            return null;
        }
        Account newAccount = new Account(balance, person);
        accountRepository.save(newAccount);
        return newAccount;
    }
}
