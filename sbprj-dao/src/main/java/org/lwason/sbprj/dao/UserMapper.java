package org.lwason.sbprj.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lwason.sbprj.dao.entity.PageIntPO;
import org.lwason.sbprj.dao.entity.PageStrPO;
import org.lwason.sbprj.dao.entity.UserPO;

import java.util.List;

@Mapper
public interface UserMapper {

    Integer batchInsertUser(@Param("po") UserPO po);

    Integer batchUpdateAge(UserPO po);

    List<UserPO> selectPageByInt(PageIntPO intPO);

    List<UserPO> selectPageByStr(PageStrPO strPO);

}
