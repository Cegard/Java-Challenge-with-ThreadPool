package com.agents;

import java.util.Random;

public class Cashier extends Agent {

    public Cashier(Client client) {
        super(client);
    }

    @Override
    public String get() {

        String msg = "Nothing done yet";

        try {
            long start = System.currentTimeMillis();
            int timeForRequest = 1000 * (new Random().nextInt(6) + 10);
            attendClient();

            Thread.sleep(timeForRequest);

            long end = System.currentTimeMillis();
            long seconds = (end - start)/1000;

            msg =  "Request done by a cashier - client: " + this.assignedClient.getName() + ". It took: " + String.valueOf(seconds) + " seconds";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return msg;
    }
}
