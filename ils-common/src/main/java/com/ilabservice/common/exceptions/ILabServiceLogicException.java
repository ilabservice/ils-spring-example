package com.ilabservice.common.exceptions;

import lombok.Data;


@Data
public class ILabServiceLogicException extends RuntimeException {
    Integer code;
    Object data;

    public ILabServiceLogicException(Integer code, String msg){
        super(msg);
        this.code = code;

        data = null;
    }

    public ILabServiceLogicException(Integer code, String msg, Object data){
        super(msg);
        this.code = code;

        this.data = data;
    }
}
