package com.utilities;

import java.util.ArrayList;
import java.util.List;

public class TransactionalLog {

    List<String> log;

    public TransactionalLog() {
        log = new ArrayList<>();
    }

    public List<String> getLog() {
        return log;
    }

    public void setLog(List<String> log) {
        this.log = log;
    }
}
