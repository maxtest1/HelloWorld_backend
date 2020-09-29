package com.mxc.web.vo;

import lombok.Data;
import java.io.Serializable;

/**
* @author robot
*/
@Data
public class ErrorResponse<T> implements Serializable {

    private String code;
    private String message;
    private T detail;

    public static <V> ErrorResponse<V> of(String code, String message) {
        ErrorResponse<V> errorResponse = new ErrorResponse<>();
        errorResponse.setCode(code);
        errorResponse.setMessage(message);
        return errorResponse;
    }

    public static <V> ErrorResponse<V> of(String code, String message, V detail) {
        ErrorResponse<V> errorResponse = new ErrorResponse<>();
        errorResponse.setCode(code);
        errorResponse.setMessage(message);
        errorResponse.setDetail(detail);
        return errorResponse;
    }
}
