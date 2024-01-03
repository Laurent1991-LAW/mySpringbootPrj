package com.lwason.sbprj.basic.listener;

public class MyListenerTest {
    public static void main(String[] args) {
        // 1. 自定义event与listener
        MyEventSourceObject sourceObject = new MyEventSourceObject();
        sourceObject.addListener(new MyListener());
        sourceObject.setName("Nathan LAW");
    }

}
