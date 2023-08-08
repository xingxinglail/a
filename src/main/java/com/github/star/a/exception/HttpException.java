package com.github.star.a.exception;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class HttpException extends RuntimeException {

    protected HttpStatus code = HttpStatus.UNPROCESSABLE_ENTITY;

    protected String message;

    public HttpException(String message) {
        super(message);
        this.message = message;
    }

    public HttpException(HttpStatus code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public HttpException(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
    }

    public HttpException(HttpStatus code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.message = message;
    }
}
