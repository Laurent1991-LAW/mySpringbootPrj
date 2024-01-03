package org.lwason.sbprj.service;

import org.lwason.sbprj.api.entity.LwasonResponse;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {
    LwasonResponse entrance(@RequestParam Integer index);
}
