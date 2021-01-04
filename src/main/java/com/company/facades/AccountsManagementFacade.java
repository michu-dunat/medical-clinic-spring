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
        long parsedPESEL = adder.inputPESEL();
        boolean ifExists = adder.checkIfUserExistsWithGivenPESEL(parsedPESEL);
        if (ifExists)
            return false;
        else {
            HashMap<String, String> patientDataHashMap = adder.inputPatientData();
            //boolean saveAccountStatus = adder.createAccount(patientDataHashMap, parsedPESEL);
            //return saveAccountStatus;
            return false;
        }
    }
}
