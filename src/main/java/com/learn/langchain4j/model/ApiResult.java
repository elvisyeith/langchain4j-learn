package com.learn.langchain4j.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一 API 响应结果封装
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> {

    private Integer code;
    private String message;
    private T data;

    public static <T> ApiResult<T> success(T data) {
        return new ApiResult<>(200, "success", data);
    }

    public static <T> ApiResult<T> success(String message, T data) {
        return new ApiResult<>(200, message, data);
    }

    public static <T> ApiResult<T> error(String message) {
        return new ApiResult<>(500, message, null);
    }

    public static <T> ApiResult<T> error(Integer code, String message) {
        return new ApiResult<>(code, message, null);
    }
}
