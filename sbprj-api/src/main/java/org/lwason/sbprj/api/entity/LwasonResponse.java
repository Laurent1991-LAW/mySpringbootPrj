package org.lwason.sbprj.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LwasonResponse {

    private String msg;
    private String respCode;
    private Object data;

    public static LwasonResponse ok() {
        return LwasonResponse.builder().respCode("200").msg("succes").build();
    }

}
