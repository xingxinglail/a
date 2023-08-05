package com.github.star.a.exception;

import com.github.star.a.common.ResultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = HttpException.class)
    @ResponseBody
    public ResultResponse bizExceptionHandler(HttpServletRequest req, HttpException e) {
        Integer code = e.getCode();
        return ResultResponse.fail(code != null ? code : -1, e.getMessage(), null);
    }

    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, NullPointerException e) {
        e.printStackTrace();
        return ResultResponse.fail("空指针异常");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResultResponse exceptionHandler(HttpServletRequest req, Exception e) {
        e.printStackTrace();
        return ResultResponse.fail("系统错误");
    }

}
