package org.lwason.sbprj.async;

import com.lwason.sbprj.common.entity.CurrentContext;
import lombok.AllArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.Map;

@AllArgsConstructor
public class MyRunnable implements Runnable {

    private final Map<String, Object> parentContext;
    private final Runnable runnable;

    @Override
    public void run() {
        try {
            if (!CollectionUtils.isEmpty(this.parentContext)) {
                this.parentContext.forEach(CurrentContext::set);
            }
            this.runnable.run();
        }
        finally {
            parentContext.clear();
        }
    }
}
