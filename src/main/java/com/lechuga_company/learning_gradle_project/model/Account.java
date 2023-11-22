package com.lechuga_company.learning_gradle_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Integer id;
    private Long balance;
    @OneToOne
    private Person owner;

    public Account() {
    }

    public Account(Long balance, Person owner) {
        this.balance = balance;
        this.owner = owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"balance\":" + balance +
                ", \"owner\":{ \"id:\"" + owner.getId() +
                ", \"name\":\"" + owner.getName() +
                "\"}}";
    }
}
