package com.Bank;

import com.Utilities.RandomNumberAccount;

public final class ClientFactory {


    public static Client createClientForClaim(String clientName, String reason){
        Client reference = new Client(clientName, RandomNumberAccount.getRandomAccount(),
                RandomNumberAccount.getRandomBalance());
        reference.doAReclaim(reason);

        return reference;
    }


    public static Client createClientForDeposit(String clientName){
        Client reference = new Client(clientName, RandomNumberAccount.getRandomAccount(),
                RandomNumberAccount.getRandomBalance());
        reference.askForDeposit(RandomNumberAccount.getRandomMoney());

        return reference;
    }


    public static Client createClientForWithdrawal(String clientName){
        Client reference = new Client(clientName, RandomNumberAccount.getRandomAccount(),
                RandomNumberAccount.getRandomBalance());
        reference.askForWithdrawals(RandomNumberAccount.getRandomMoney());

        return reference;
    }
}
