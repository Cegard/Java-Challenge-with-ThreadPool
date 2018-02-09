package com.Bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public abstract class Agent implements Supplier<String> {

    protected Client assignedClient;
    protected int employeeID;
    private List<String> reclaimsForClients;
    private HashMap<Request, BankOperation> operations = new HashMap<>();


    public Agent(Client assignedClient) {
        this.assignedClient = assignedClient;
        this.reclaimsForClients = new ArrayList<>();
        this.operations.put(Request.DEPOSIT, this.deposit);
        this.operations.put(Request.WITHDRAWALS, this.withdrawals);
        this.operations.put(Request.RECLAIM, this.reclaim);
    }


    public void assignClient(Client client) {
        this.assignedClient = client;
    }


    private BankOperation deposit = () -> {
        this.assignedClient.setBalance(this.assignedClient.getBalance()+
                this.assignedClient.getMoneyForTransaction());
    };


    private BankOperation withdrawals = () -> {

        if (this.assignedClient.getBalance() - this.assignedClient.getMoneyForTransaction() < 0)
            throw new IllegalStateException("Balance can not be negative. You do not have enough money");

        this.assignedClient.setBalance(this.assignedClient.getBalance() -
                this.assignedClient.getMoneyForTransaction());
    };


    private BankOperation reclaim = () -> {
        this.reclaimsForClients.add(this.assignedClient.getReclaim());
    };


    public void attendClient() {

        Request clientRequest = this.assignedClient.getRequest();
        this.operations.get(clientRequest).operation();
    }


    @Override
    public String get() {
        String msg = "";

        try {
            int timeForRequest = (new Random().nextInt(6) + 10);
            int timeToSleep = 1000 * timeForRequest;
                    attendClient();
            Thread.sleep(timeToSleep);
            msg =  "Request done by a " + this.getClass().getSimpleName() + " - Client: " +
                    this.assignedClient.getName() +
                    ". It took: " + timeForRequest + " seconds";
        }

        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return msg;
    }


    public int getEmployeeID() {
        return employeeID;
    }


    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }


    public List<String> getReclaimsForClients() {
        return reclaimsForClients;
    }
}
