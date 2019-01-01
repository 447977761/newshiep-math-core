package com.shiep.math.core.common;


import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by za-yutao on 2017/3/16.
 */
public class ResponseEntity<T> {

    private boolean isSuccess = false;
    private String  message;
    private String  code;
    private T       result;

    public ResponseEntity() {
        super();
    }

    public ResponseEntity(T result) {
        super();
        this.isSuccess = true;
        this.result = result;
    }

    public ResponseEntity(String message, String code) {
        super();
        this.isSuccess = false;
        this.message = message;
        this.code = code;
    }

    public ResponseEntity(boolean success, String message, String code) {
        super();
        this.isSuccess = success;
        this.message = message;
        this.code = code;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
