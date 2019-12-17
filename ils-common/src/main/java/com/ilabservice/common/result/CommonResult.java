package com.ilabservice.common.result;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;

/**
 * 通用服务结果
 *
 * @author zxy
 * @version $Id: CommonResult.java
 */
@Data
@ResponseBody
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = -1848071965814004979L;
    /**
     * 操作是否成功
     */
    private boolean success = true;
    /**
     * 结果码
     */
    private Integer code = ResultErrorCode.SUCCESS.getCode();
    /**
     * 结果描述
     */
    private String message = ResultErrorCode.SUCCESS.getValue();
    /**
     * 结果
     */
    private T data;

    /**
     * 默认构造函数
     */
    public CommonResult() {
        super();
    }

    public CommonResult(boolean success, Integer code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 失败构造函数
     *
     * @param code
     * @param message
     * @param data
     */
    public CommonResult(Integer code, String message, T data) {
        this.success = false;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(T data) {
        this.data = data;
    }


    public boolean isSuccess() {
        return success;
    }


    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

