package com.agents;

import com.utilities.TransactionalLog;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dispatcher {

    private ExecutorService executorService;
    private TransactionalLog transactionalLog;
    private int freeCashiers;
    private int freeSupervisor;
    private int freeDirector;

    public Dispatcher() {
        executorService = Executors.newFixedThreadPool(10);
        transactionalLog = new TransactionalLog();
        freeCashiers = 7;
        freeSupervisor = 2;
        freeDirector = 1;
    }

    public Dispatcher(int numberOfThreads) {
        executorService = Executors.newFixedThreadPool(numberOfThreads);
        transactionalLog = new TransactionalLog();
        freeCashiers = 7;
        freeSupervisor = 2;
        freeDirector = 1;
    }

    public void attend(Client client) {

        if(freeCashiers > 0) {
            freeCashiers--;
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Cashier(client), executorService);
            completableFuture.thenAccept(returnValue -> {transactionalLog.getLog().add(returnValue); System.out.println(returnValue); freeCashiers++;});
        }else if(freeSupervisor > 0) {
            freeSupervisor--;
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supervisor(client), executorService);
            completableFuture.thenAccept(returnValue -> {transactionalLog.getLog().add(returnValue); System.out.println(returnValue); freeSupervisor++;});
        }else if (freeDirector > 0) {
            freeDirector--;
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Director(client), executorService);
            completableFuture.thenAccept(returnValue -> {transactionalLog.getLog().add(returnValue); System.out.println(returnValue); freeDirector++;});
        }else {
            //All busy, just queue
            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Cashier(client), executorService);
            completableFuture.thenAccept(returnValue -> {transactionalLog.getLog().add(returnValue); System.out.println(returnValue);});
        }

    }

    public void closeBank() {
        executorService.shutdown();
    }

}
