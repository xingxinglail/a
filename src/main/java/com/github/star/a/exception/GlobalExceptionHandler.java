package com.github.star.a.exception;

import com.github.star.a.common.ResultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = HttpException.class)
    @ResponseBody
    public ResponseEntity<?> bizExceptionHandler(HttpServletRequest req, HttpException e) {
        Map<String, String> map = new HashMap<>();
        map.put("message", e.getMessage());
        e.printStackTrace();
        return new ResponseEntity<>(map, e.getCode());
    }

    @ExceptionHandler(value = {NullPointerException.class, Exception.class})
    @ResponseBody
    public ResponseEntity<?> exceptionHandler(HttpServletRequest req, Exception e) {
        String message = e.toString();
        if (e instanceof MethodArgumentNotValidException) {
            message = Objects.requireNonNull(((MethodArgumentNotValidException) e).getFieldError()).getDefaultMessage();
        }
        Map<String, String> map = new HashMap<>();
        map.put("message", message);
        e.printStackTrace();
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
