package com.Main;

import com.Bank.BankQueue;
import com.Bank.Client;
import com.Bank.ClientFactory;
import com.Bank.Dispatcher;
import com.Utilities.RandomNumberAccount;

public class Main {

    public static void main(String[] args) {
        BankQueue bankQueue  = new BankQueue();

        bankQueue.putClientInQueue(ClientFactory.createClientForDeposit("Juan"));
        bankQueue.putClientInQueue(ClientFactory.createClientForDeposit("Pedro"));
        bankQueue.putClientInQueue(ClientFactory.createClientForDeposit("Pablo"));
        bankQueue.putClientInQueue(ClientFactory.createClientForWithdrawal("Eduardo"));
        bankQueue.putClientInQueue(ClientFactory.createClientForWithdrawal("Alberto"));
        bankQueue.putClientInQueue(ClientFactory.createClientForWithdrawal("Javier"));
        bankQueue.putClientInQueue(ClientFactory.createClientForDeposit("Alejandra"));
        bankQueue.putClientInQueue(ClientFactory.createClientForDeposit("Miguel"));
        bankQueue.putClientInQueue(ClientFactory.createClientForDeposit("David"));
        bankQueue.putClientInQueue(ClientFactory.createClientForClaim("Andres", "too slow"));
        bankQueue.putClientInQueue(ClientFactory.createClientForClaim("Mauricio",
                "I want to change my number account"));
        bankQueue.putClientInQueue(ClientFactory.createClientForDeposit("Sebastian"));

        Dispatcher dispatcher = new Dispatcher();

        while(!bankQueue.bankQueueIsEmpty())
            dispatcher.attend(bankQueue.assignClient());

        dispatcher.closeBank();
    }
}
