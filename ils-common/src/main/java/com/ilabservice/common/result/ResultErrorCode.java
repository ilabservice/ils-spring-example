package com.ilabservice.common.result;

public enum ResultErrorCode {
    ERROR_DATA(500, "{'code':500,'message':'系统错误'}"),
    /**
     * 成功狀態碼
     */
    SUCCESS(0, "Succeed"),

    /**
     * HTTP常用状态码
     */
    REQUEST_SUCCESS(200, "REQUEST_SUCCESS"),
    NO_CONTENT(204, "NO_CONTENT"),
    PARTIAL_CONTENT(206, "PARTIAL_CONTENT"),
    MOVED_PERMANENTLY(301, "MOVED_PERMANENTLY"),
    FOUND(302, "FOUND"),
    SEE_OTHER(303, "SEE_OTHER"),
    NOT_MODIFIED(304, "NOT_MODIFIED"),
    TEMPORARY_REDIRECT(307, "TEMPORARY_REDIRECT"),
    NOT_PERMISSION(401, "NOT_PERMISSION"),
    FORBIDDEN(403, "FORBIDDEN"),
    NOT_FOUND_PAGE_OR_URL_OR_MODEL(404, "NOT_FOUND_PAGE_OR_URL_OR_MODEL"),
    DELETE_INFO_ERROR(409, "DELETE_INFO_ERROR"),
    SERVER_ERROR(500, "SERVER_ERROR"),
    SERVICE_UNAVAILABLE(503, "SERVICE_UNAVAILABLE"),

    /**
     * 数据库
     */
    DB_ERROR(11, "DATABASE_ERROR"),
    DB_INSERT_ERROR(12, "DB_INSERT_ERROR"),
    DB_UPDATE_ERROR(13, "DB_INSERT_ERROR"),
    DB_DELETE_ERROR(14, "DB_DELETE_ERROR");

    private String value;
    private int code;

    ResultErrorCode(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public int getCode() {
        return code;
    }


    public static ResultErrorCode codeOf(int code) {
        for (ResultErrorCode resultErrorCodeEnum : values()) {
            if (resultErrorCodeEnum.getCode() == code) {
                return resultErrorCodeEnum;
            }
        }
        throw new RuntimeException("没有找到对应枚举");
    }
}
