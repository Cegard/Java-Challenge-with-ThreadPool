package com.Bank;

import com.Utilities.Counter;
import com.Utilities.TransactionalLog;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Dispatcher {

    private ExecutorService executorService;
    private TransactionalLog transactionalLog;
    private Counter freeCashiers;
    private Counter freeSupervisor;
    private Counter freeDirector;


    private void initializeCommonAtts(){
        transactionalLog = new TransactionalLog();
        freeCashiers = new Counter(7);
        freeSupervisor = new Counter(2);
        freeDirector = new Counter(1);
    }


    public Dispatcher() {
        executorService = Executors.newFixedThreadPool(10);
        initializeCommonAtts();
    }


    public Dispatcher(int numberOfThreads) {
        executorService = Executors.newFixedThreadPool(numberOfThreads);
        initializeCommonAtts();
    }


    public void attend(Client client) {

        if(freeCashiers.getCount() > 0)
            this.attendForReal(freeDirector, new Cashier(client));

        else if(freeSupervisor.getCount() > 0)
            this.attendForReal(freeDirector, new Supervisor(client));

        else if (freeDirector.getCount() > 0)
            this.attendForReal(freeDirector, new Director(client));

        else {
            //All busy, just queue
            CompletableFuture<String> completableFuture =
                    CompletableFuture.supplyAsync(new Cashier(client), executorService);
            completableFuture.thenAccept(returnValue -> {
                transactionalLog.getLog().add(returnValue);
                System.out.println(returnValue);});
        }
    }


    private void attendForReal(Counter agentCounter, Agent agent){
        agentCounter.sustractOneToCount();
        CompletableFuture<String> completableFuture =
                CompletableFuture.supplyAsync(agent, executorService);
        completableFuture.thenAccept(returnValue -> {
            transactionalLog.getLog().add(returnValue);
            System.out.println(returnValue);
            agentCounter.addOneToCount();
        });
    }


    public void closeBank() {
        executorService.shutdown();
    }
}
