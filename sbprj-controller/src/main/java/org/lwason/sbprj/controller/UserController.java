package org.lwason.sbprj.controller;

import org.lwason.sbprj.api.UserApi;
import org.lwason.sbprj.api.entity.LwasonResponse;
import org.lwason.sbprj.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController

public class UserController implements UserApi {

    @Resource
    UserService userServiceImpl;

    @Override
    public LwasonResponse entrance(@RequestParam Integer index) {
        return userServiceImpl.entrance(index);
    }

}
