package com.agents;

public interface IClient {

    void askForDeposit(double moneyForTransaction);
    void askForWithdrawals(double moneyForTransaction);
    void doAReclaim(String reclaim);
}
