package org.lwason.sbprj.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class UserInfo {

    private String usrName;
    private String accountNo;
    private String instNo;

}
