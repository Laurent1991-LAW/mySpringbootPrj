package org.lwason.sbprj.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPO {

    private String id;
    private String userId;
    private String userName;
    private int age;
    private BigDecimal income;

    private String batchBlock;

}
