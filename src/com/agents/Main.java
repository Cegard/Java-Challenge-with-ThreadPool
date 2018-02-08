package com.agents;

import com.utilities.RandomNumberAccount;

public class Main {

    public static void main(String[] args) {

        BankQueue bankQueue  = new BankQueue();
        Client reference;


        reference = new Client("Juan", RandomNumberAccount.getRandomAccount(), RandomNumberAccount.getRandomBalance());
        reference.askForDeposit(RandomNumberAccount.getRandomMoney());
        bankQueue.putClientInQueue(reference);

        reference = new Client("Pedro", RandomNumberAccount.getRandomAccount(), RandomNumberAccount.getRandomBalance());
        reference.askForDeposit(RandomNumberAccount.getRandomMoney());
        bankQueue.putClientInQueue(reference);

        reference = new Client("Pablo", RandomNumberAccount.getRandomAccount(), RandomNumberAccount.getRandomBalance());
        reference.askForDeposit(RandomNumberAccount.getRandomMoney());
        bankQueue.putClientInQueue(reference);

        reference = new Client("Eduardo", RandomNumberAccount.getRandomAccount(), RandomNumberAccount.getRandomBalance());
        reference.askForWithdrawals(RandomNumberAccount.getRandomMoney());
        bankQueue.putClientInQueue(reference);

        reference = new Client("Alberto", RandomNumberAccount.getRandomAccount(), RandomNumberAccount.getRandomBalance());
        reference.askForWithdrawals(RandomNumberAccount.getRandomMoney());
        bankQueue.putClientInQueue(reference);

        reference = new Client("Javier", RandomNumberAccount.getRandomAccount(), RandomNumberAccount.getRandomBalance());
        reference.askForWithdrawals(RandomNumberAccount.getRandomMoney());
        bankQueue.putClientInQueue(reference);

        reference = new Client("Alejandra", RandomNumberAccount.getRandomAccount(), RandomNumberAccount.getRandomBalance());
        reference.askForDeposit(RandomNumberAccount.getRandomMoney());
        bankQueue.putClientInQueue(reference);

        reference = new Client("Miguel", RandomNumberAccount.getRandomAccount(), RandomNumberAccount.getRandomBalance());
        reference.askForDeposit(RandomNumberAccount.getRandomMoney());
        bankQueue.putClientInQueue(reference);

        reference = new Client("David", RandomNumberAccount.getRandomAccount(), RandomNumberAccount.getRandomBalance());
        reference.askForDeposit(RandomNumberAccount.getRandomMoney());
        bankQueue.putClientInQueue(reference);

        reference = new Client("Andres", RandomNumberAccount.getRandomAccount(), RandomNumberAccount.getRandomBalance());
        reference.doAReclaim("Too slow");
        bankQueue.putClientInQueue(reference);

        reference = new Client("Mauricio", RandomNumberAccount.getRandomAccount(), RandomNumberAccount.getRandomBalance());
        reference.doAReclaim("I want to change my number account");
        bankQueue.putClientInQueue(reference);

        reference = new Client("Sebastian", RandomNumberAccount.getRandomAccount(), RandomNumberAccount.getRandomBalance());
        reference.askForDeposit(RandomNumberAccount.getRandomMoney());
        bankQueue.putClientInQueue(reference);


        Dispatcher dispatcher = new Dispatcher();

        while(!bankQueue.bankQueueIsEmpty()) {
            dispatcher.attend(bankQueue.assignClient());
        }

        dispatcher.closeBank();

    }
}
