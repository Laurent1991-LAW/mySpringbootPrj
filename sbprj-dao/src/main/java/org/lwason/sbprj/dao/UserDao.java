package org.lwason.sbprj.dao;

import com.lwason.sbprj.common.entity.User;

import java.sql.SQLException;

public class UserDao {
    public User save(String name, String phone, String repId) throws SQLException {
        return new User(name, phone, repId);
    }
}
