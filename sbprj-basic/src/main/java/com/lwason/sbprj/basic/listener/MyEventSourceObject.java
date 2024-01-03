package com.lwason.sbprj.basic.listener;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyEventSourceObject {

    private String name;
    // 监听器容器
    private Set<MyListener> listener;

    public MyEventSourceObject() {
        this.listener = new HashSet<MyListener>(1);
        this.name = "defaultName";
    }

    // 给事件源注册监听器
    public void addListener(MyListener cel) {
        this.listener.add(cel);
    }

    // 当事件发生时,通知注册在该事件源上的所有监听器做出相应的反应（调用回调方法）
    protected void notifies() {
        MyListener cel = null;
        Iterator<MyListener> iterator = this.listener.iterator();
        while (iterator.hasNext()) {
            cel = iterator.next();
            cel.onEvent(new MyEvent(this));
        }
    }

    public String getName() {
        return name;
    }

    /**
     * 模拟事件触发器，当成员变量name的值发生变化时，触发事件。
     * @param name
     */
    public void setName(String name) {
        if (!this.name.equals(name)) {
            this.name = name;
            notifies();
        }
    }


}
