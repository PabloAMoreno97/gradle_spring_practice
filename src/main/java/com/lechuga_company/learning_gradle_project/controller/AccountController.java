package com.lechuga_company.learning_gradle_project.controller;

import com.lechuga_company.learning_gradle_project.model.Account;
import com.lechuga_company.learning_gradle_project.model.AccountRequest;
import com.lechuga_company.learning_gradle_project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/{personId}")
    public Account getPersonAccount(@PathVariable Long personId){
        return accountService.getAccount(personId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> saveAccount(@RequestBody AccountRequest accountRequest){
        Account account = accountService.saveAccount(accountRequest.getBalance(), accountRequest.getPersonId());
        if (account == null){
            return ResponseEntity.badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"Error\":\"The account cannot be created.\"}");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(account.toString());
    }

}
