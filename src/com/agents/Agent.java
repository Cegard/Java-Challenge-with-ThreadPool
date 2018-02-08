package com.agents;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class Agent implements Supplier<String> {

    protected Client assignedClient;
    private List<String> reclaimsForClients;

    public Agent(Client assignedClient) {
        this.assignedClient = assignedClient;
        this.reclaimsForClients = new ArrayList<>();
    }

    public void assignClient(Client client) {
        this.assignedClient = client;
    }

    private void deposit() {
        this.assignedClient.setBalance(this.assignedClient.getBalance()+this.assignedClient.getMoneyForTransaction());
    }

    private double withdrawals() {
        if(this.assignedClient.getBalance() - this.assignedClient.getMoneyForTransaction() < 0)
            throw new IllegalStateException("Balance can not be negative. You do not have enough money");
        this.assignedClient.setBalance(this.assignedClient.getBalance() - this.assignedClient.getMoneyForTransaction());
        return this.assignedClient.getBalance();
    }

    private void reclaim() {
        this.reclaimsForClients.add(this.assignedClient.getReclaim());
    }

    public void attendClient() {

        Request clientRequest = this.assignedClient.getRequest();

        switch(clientRequest) {
            case DEPOSITE:
                deposit();
                break;

            case WITHDRAWALS:
                withdrawals();
                break;

            case RECLAIM:
                reclaim();
                break;

            default:
                System.out.println("Illegal Argument");
                break;
        }
    }

    public List<String> getReclaimsForClients() {
        return reclaimsForClients;
    }

}
