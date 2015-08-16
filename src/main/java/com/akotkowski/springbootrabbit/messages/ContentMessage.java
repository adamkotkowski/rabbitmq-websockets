package com.akotkowski.springbootrabbit.messages;

/**
 * Created by adam on 16/08/15.
 */
public class ContentMessage {
    private String content;


    public ContentMessage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
