package com.lechuga_company.learning_gradle_project.model;

public class AccountRequest {
    private Long balance;
    private Long personId;

    public AccountRequest() {
    }

    public AccountRequest(Long balance, Long personId) {
        this.balance = balance;
        this.personId = personId;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }
}
