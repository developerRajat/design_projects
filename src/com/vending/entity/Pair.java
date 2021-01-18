package com.vending.entity;

public class Pair<o1, o2> {

    o1 key;
    o2 value;

    public Pair(o1 key, o2 value) {
        this.key = key;
        this.value = value;
    }

    public o1 getKey() {
        return key;
    }

    public void setKey(o1 key) {
        this.key = key;
    }

    public o2 getValue() {
        return value;
    }

    public void setValue(o2 value) {
        this.value = value;
    }
}