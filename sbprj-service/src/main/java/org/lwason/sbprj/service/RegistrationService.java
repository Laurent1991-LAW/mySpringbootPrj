package org.lwason.sbprj.service;

import com.lwason.sbprj.common.entity.User;

public interface RegistrationService {
    User register(String name, String phone) throws Exception;
}
