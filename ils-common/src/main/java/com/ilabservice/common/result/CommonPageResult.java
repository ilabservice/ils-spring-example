package com.ilabservice.common.result;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 分页查询返回结果
 *
 * @author zxy
 * @since 1.0.1
 * Created by zxy on 2019/8/26.
 */
@Data
@ResponseBody
public class CommonPageResult<T> extends CommonResult<T> {

    private static final long serialVersionUID = -7316136625437068129L;

    /**
     * 查询总数
     */
    private int totalCount;
    /**
     * 当前页
     */
    private int pageNum;
    /**
     * 分页数量
     */
    private int pageSize;

    public CommonPageResult(T data) {
        super(data);
    }

    public CommonPageResult() {
        super();
    }

    /**
     * 异常构造函数
     *
     * @param code
     * @param message
     * @param data
     */
    public CommonPageResult(Integer code, String message, T data) {
        super(code, message, data);
    }

    public CommonPageResult(boolean success, Integer code, String message, T data) {
        super(success, code, message, data);
    }


}

