package com.utilities;

import java.util.Random;

public class RandomNumberAccount {

    public static String getRandomAccount() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; ++i) {
            char randomNumber = (char) (new Random().nextInt(26) + 65);
            sb.append(randomNumber);
        }

        sb.append('-');

        for (int i = 0; i < 3; ++i) {
            int randomNumber = (new Random().nextInt(10));
            sb.append(randomNumber);
        }
        return sb.toString();
    }

    public static double getRandomBalance() {
        return new Random().nextInt(99999) + 10000.0;
    }

    public static double getRandomMoney() {
        return new Random().nextInt(999) + 1000.0;
    }
}
