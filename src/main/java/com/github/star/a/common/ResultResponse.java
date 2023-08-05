package com.github.star.a.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultResponse<T> {

    int code;

    String message;

    T result;

    public static <T> ResultResponse<T> success(T data) {
        return ResultResponse.<T>builder().code(0).message("success").result(data).build();
    }

    public static <T> ResultResponse<T> success() {
        return success(null);
    }

    public static <T> ResultResponse<T> fail(int code, String message, T data) {
        return ResultResponse.<T>builder().code(code).message(message).result(data).build();
    }

    public static <T> ResultResponse<T> fail(String message) {
        return fail(-1, message, null);
    }
}
