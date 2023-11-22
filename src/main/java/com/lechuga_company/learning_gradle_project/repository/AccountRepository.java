package com.lechuga_company.learning_gradle_project.repository;

import com.lechuga_company.learning_gradle_project.model.Account;
import com.lechuga_company.learning_gradle_project.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByOwner(Person person);
}
