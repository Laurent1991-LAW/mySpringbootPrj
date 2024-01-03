package org.lwason.sbprj.controller;

import org.lwason.sbprj.api.WebTestApi;
import org.lwason.sbprj.api.entity.LwasonResponse;
import org.lwason.sbprj.service.WebTestService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class WebTestController implements WebTestApi {

    @Resource
    private WebTestService webTestService;

    @Override
    public LwasonResponse test1() {
        webTestService.test1();
        return LwasonResponse.ok();
    }

    @Override
    public LwasonResponse feignTest() {
        webTestService.feignTest();
        return LwasonResponse.ok();
    }

    @Override
    public LwasonResponse consume() {
        webTestService.consume();
        return LwasonResponse.ok();
    }
}
