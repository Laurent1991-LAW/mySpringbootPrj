package org.lwason.sbprj.dao;

import com.lwason.sbprj.common.entity.SalesRep;

public class SalesDao {
    public SalesRep findRep(String areaCode, String operatorCode) {
        if ("a".equals(areaCode) && "b".equals(operatorCode)) {
            return new SalesRep("Echo");
        }
        return null;
    }
}
