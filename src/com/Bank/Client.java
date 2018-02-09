package com.Bank;

public class Client{

    private String name;
    private String account;
    private double balance;
    private Request request;

    private double moneyForTransaction;
    private String reclaim;


    public Client(String name, String account, double balance) {
        this.setName(name);
        this.setAccount(account);
        this.setBalance(balance);
    }

    public Client(String name, String account, double balance, Request request) {
        this.setName(name);
        this.setAccount(account);
        this.setBalance(balance);
        this.setRequest(request);
    }


    public void askForDeposit(double moneyForTransaction) {
        this.request = Request.DEPOSIT;
        this.setMoneyForTransaction(moneyForTransaction);
    }


    public void askForWithdrawals(double moneyForTransaction) {
        this.request = Request.WITHDRAWALS;
        this.setMoneyForTransaction(moneyForTransaction);
    }


    public void doAReclaim(String reclaim) {
        this.request = Request.RECLAIM;
        this.setReclaim(reclaim);
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAccount() {
        return account;
    }


    public void setAccount(String account) {
        this.account = account;
    }


    public double getBalance() {
        return balance;
    }


    public void setBalance(double balance) {
        this.balance = balance;
    }


    public Request getRequest() {
        return request;
    }


    public void setRequest(Request request) {
        this.request = request;
    }


    public double getMoneyForTransaction() {
        return moneyForTransaction;
    }


    public void setMoneyForTransaction(double moneyForTransaction) {
        this.moneyForTransaction = moneyForTransaction;
    }


    public String getReclaim() {
        return reclaim;
    }


    public void setReclaim(String reclaim) {
        this.reclaim = reclaim;
    }
}
