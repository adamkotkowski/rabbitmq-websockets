package com.akotkowski.springbootrabbit.messages;

/**
 * Created by adam on 16/08/15.
 */
public class HelloMessage {
    private String name;

    public HelloMessage() {
        this("stranger");
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
