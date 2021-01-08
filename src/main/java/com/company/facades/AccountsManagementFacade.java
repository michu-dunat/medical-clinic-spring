package com.company.facades;

import com.company.handlers.AddAccountHandler;

import java.util.HashMap;

public class AccountsManagementFacade implements IAccountsManagementFacade {

    private AddAccountHandler adder;

    @Override
    public boolean addAccountByAdmin() {
        return false;
    }

    @Override
    public boolean addAccountByWorker() {
        return false;
    }
}
