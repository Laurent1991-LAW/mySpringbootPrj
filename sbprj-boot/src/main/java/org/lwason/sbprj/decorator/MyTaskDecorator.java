package org.lwason.sbprj.decorator;

import com.lwason.sbprj.common.entity.CurrentContext;
import org.lwason.sbprj.async.MyRunnable;
import org.springframework.core.task.TaskDecorator;

public class MyTaskDecorator implements TaskDecorator {
    @Override
    public Runnable decorate(Runnable runnable) {
        return new MyRunnable(CurrentContext.threadLocal.get(), runnable);
    }
}
