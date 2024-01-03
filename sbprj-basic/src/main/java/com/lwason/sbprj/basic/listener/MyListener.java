package com.lwason.sbprj.basic.listener;

import lombok.extern.slf4j.Slf4j;

import java.util.EventListener;

@Slf4j
public class MyListener implements EventListener {

    // 监听事件方法 入参为event 即event发生时将执行的操作
    public void onEvent(MyEvent event) {
        log.info("onEvent begin : EventSource Name has change !");
        log.info("onEvent doing his task... !");
        MyEventSourceObject source = (MyEventSourceObject) event.getSource();
        log.info("onEvent end :  EventSource Name has been changed to " + source.getName());
    }
}
