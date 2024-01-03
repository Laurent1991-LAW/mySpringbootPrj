package org.lwason.sbprj.service.impl;

import com.lwason.sbprj.common.entity.CurrentContext;
import lombok.extern.slf4j.Slf4j;
import org.lwason.sbprj.service.WebTestService;
import org.lwason.sbprj.spi.ConsumerSpi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

@Slf4j
@Service
public class WebTestServiceImpl implements WebTestService {

    @Resource
    private Executor executor;

    @Resource
    private ConsumerSpi consumerSpi;

    @Override
    public void test1() {
        getAsyncContextInfo();
    }

    @Override
    public void feignTest() {
        getContextInfo("feignTest");
        consumerSpi.consume();
    }

    @Override
    public void consume() {
        getContextInfo("consume");
    }

    private void getAsyncContextInfo() {
        executor.execute(() -> {
            getContextInfo("test1");
        });
    }

    private void getContextInfo(String methodName) {
        log.info(String.format("---WebTestServiceImpl.%s---", methodName));
        log.info("global busi track no is : {}", CurrentContext.getGlobalBusiTrackNo());
        log.info(String.format("---WebTestServiceImpl.%s finish---", methodName));
    }

}
