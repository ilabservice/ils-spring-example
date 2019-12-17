package com.ilabservice.service.exceptions;

import com.ilabservice.common.exceptions.BadRequestException;
import com.ilabservice.common.exceptions.ILabServiceLogicException;
import com.ilabservice.common.exceptions.NotFoundException;
import com.ilabservice.common.exceptions.ServerInternalException;
import com.ilabservice.common.result.CommonResult;
import com.ilabservice.common.result.ResponseMessageCollection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Value("${runtime.debug:#{false}}")
    Boolean runtimeDebug;

    private String getTranslatedMessage(String headerLang, String message){
        if (headerLang == null) {
            headerLang = ResponseMessageCollection.DEFAULT_LANGUAGE;
        }

        if (ResponseMessageCollection.errorMessageByLanguage.get(headerLang.toLowerCase()) != null
                && ResponseMessageCollection.errorMessageByLanguage.get(headerLang.toLowerCase()).containsKey(message)) {
            return ResponseMessageCollection.errorMessageByLanguage.get(headerLang.toLowerCase()).get(message);
        } else {
            return message;
        }
    }

    /**
     * 逻辑错误http 返回码为 200, 实际错误码在 entity 里的 code 字段
     * @param request
     * @param err
     * @return
     */
    @ExceptionHandler(ILabServiceLogicException.class)
    @ResponseBody
    public CommonResult<Object> handleLogicErrorException(HttpServletRequest request, ILabServiceLogicException err) {

        CommonResult<Object> errorInfo = new CommonResult<>();
        errorInfo.setSuccess(false);
        errorInfo.setCode(err.getCode());

        errorInfo.setMessage(getTranslatedMessage(request.getHeader("x-language"), err.getMessage()));
        errorInfo.setData(null);

        return errorInfo;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    public CommonResult<Object> handleBadRequestException(HttpServletRequest request, BadRequestException err) {

        CommonResult<Object> errorInfo = new CommonResult<>();
        errorInfo.setSuccess(false);
        errorInfo.setMessage(getTranslatedMessage(request.getHeader("x-language"), err.getMessage()));
        errorInfo.setData(null);
        errorInfo.setCode(400);

        return errorInfo;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public CommonResult<Object> handleNotFoundException(HttpServletRequest request, NotFoundException err) {

        CommonResult<Object> errorInfo = new CommonResult<>();
        errorInfo.setSuccess(false);
        errorInfo.setMessage(getTranslatedMessage(request.getHeader("x-language"), err.getMessage()));
        errorInfo.setData(null);
        errorInfo.setCode(404);

        return errorInfo;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServerInternalException.class)
    @ResponseBody
    public CommonResult<Object> handleServerInternalException(HttpServletRequest request, ServerInternalException err) {

        CommonResult<Object> errorInfo = new CommonResult<>();
        errorInfo.setSuccess(false);
        if (runtimeDebug) {
            errorInfo.setMessage(getTranslatedMessage(request.getHeader("x-language"), err.getMessage()));
        } else {
            errorInfo.setMessage(getTranslatedMessage(request.getHeader("x-language"), "INTERNAL_SERVER_ERROR"));
        }
        errorInfo.setData(null);
        errorInfo.setCode(500);

        return errorInfo;
    }

}

