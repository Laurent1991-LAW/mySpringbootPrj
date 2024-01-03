package org.lwason.sbprj.api;

import org.lwason.sbprj.api.entity.LwasonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/webTest")
public interface WebTestApi {

    @GetMapping("/test1")
    LwasonResponse test1();

    @GetMapping("/feignTest")
    LwasonResponse feignTest();

    @RequestMapping("/consume")
    LwasonResponse consume();

}
