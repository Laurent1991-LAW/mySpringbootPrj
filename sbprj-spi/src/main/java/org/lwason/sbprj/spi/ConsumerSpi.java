package org.lwason.sbprj.spi;

import org.lwason.sbprj.api.entity.LwasonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("service-consumer")
public interface ConsumerSpi {

    @RequestMapping("/webTest/consume")
    public LwasonResponse consume();

}
