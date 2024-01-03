package com.lwason.sbprj.basic.listener;

import java.util.EventObject;

public class MyEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public MyEvent(Object source) {
        super(source);   /**  source相当于发起事件的主体 */
    }
}
