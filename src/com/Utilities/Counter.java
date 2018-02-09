package com.Utilities;

public class Counter {

    private int count;


    public Counter(int initialCount){
        this.count = initialCount;
    }


    public Counter(){
        this.count = 0;
    }


    public int getCount() {
        return this.count;
    }


    public void addOneToCount(){
        this.count++;
    }


    public void sustractOneToCount(){
        this.count--;
    }
}
