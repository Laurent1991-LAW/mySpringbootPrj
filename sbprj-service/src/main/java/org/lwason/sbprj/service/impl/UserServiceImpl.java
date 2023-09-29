package org.lwason.sbprj.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.lwason.sbprj.api.entity.LwasonResponse;
import org.lwason.sbprj.dao.UserMapper;
import org.lwason.sbprj.dao.entity.PageIntPO;
import org.lwason.sbprj.dao.entity.PageStrPO;
import org.lwason.sbprj.dao.entity.UserPO;
import org.lwason.sbprj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public LwasonResponse entrance(Integer index) {

        switch (index) {
            case 1:
                switchCase1();
                break;
            case 2:
                switchCase2();
                break;
            case 3:
                switchCase3();
                break;
            case 4:
                switchCase4();
                break;
            default:
                break;
        }



        return LwasonResponse.ok();
    }

    private void switchCase4() {
        PageStrPO po = PageStrPO.builder()
                .pageIndex("0")
                .pageSize("10")
                .build();
        List<UserPO> userPOS = userMapper.selectPageByStr(po);
        log.info("查询返回信息为:{}", userPOS);

    }

    private void switchCase3() {
        PageIntPO po = PageIntPO.builder()
                .pageIndex(0)
                .pageSize(10)
                .build();
        List<UserPO> userPOS = userMapper.selectPageByInt(po);
        log.info("查询返回信息为:{}", userPOS);
    }


    /**
     * 批量更新
     */
    private void switchCase2() {
        UserPO po = UserPO.builder()
                .age(15)
                .batchBlock("(1,2)")
                .build();
        userMapper.batchUpdateAge(po);

    }

    /**
     * 批量insert
     */
    private void switchCase1() {
        UserPO po = UserPO.builder()
                .batchBlock("('001','lucas',12,123.5),('002','Theo',12,123.5);")
                .build();
        userMapper.batchInsertUser(po);
    }

}
