package org.lwason.sbprj.api;

import org.lwason.sbprj.api.entity.LwasonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sbprj")
public interface UserApi {

    @GetMapping("/entrance")
    LwasonResponse entrance(Integer index);

}
