package com.agents;

import java.util.LinkedList;

public class BankQueue {

    private LinkedList<Client> clientsQueue;

    public BankQueue() {
        this.clientsQueue = new LinkedList<>();
    }

    public void putClientInQueue(Client client) {
        clientsQueue.add(client);
    }

    public Client assignClient() {
        return clientsQueue.pop();
    }

    public boolean bankQueueIsEmpty() {
        return clientsQueue.isEmpty();
    }
}
