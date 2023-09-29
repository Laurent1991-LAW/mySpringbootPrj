package org.lwason.sbprj.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageIntPO {

    private Integer pageSize;
    private Integer pageIndex;

}
