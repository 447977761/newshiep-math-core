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

    public static <T> Builder<T> builder() {
        return new Builder<T>();
    }

    public static class Builder<T> {

        private T result;

        private boolean isSuccess = false;

        private String  message;

        private String  code;

        public Builder<T> result(T result) {
            this.result = result;
            return this;
        }

        public Builder<T> success() {
            this.isSuccess = true;
            this.code = MdpErrorCodeEnum.REQUEST_SUCCESS_200.getCode();
            this.message = MdpErrorCodeEnum.REQUEST_SUCCESS_200.getDesc();
            return this;
        }

        public Builder<T> success(String message) {
            this.isSuccess = true;
            this.code = MdpErrorCodeEnum.REQUEST_SUCCESS_200.getCode();
            this.message = message;
            return this;
        }

        public Builder<T> fail(String code, String message) {
            this.isSuccess = false;
            this.code = code;
            this.message = message;
            return this;
        }

        public Builder<T> fail(MdpErrorCodeEnum errorCodeEnum) {
            this.isSuccess = false;
            this.code = errorCodeEnum.getCode();
            this.message = errorCodeEnum.getDesc();
            return this;
        }

        public Builder<T> fail(ResponseEntity responseEntity) {
            this.isSuccess = false;
            this.code = responseEntity.getCode();
            this.message = responseEntity.getMessage();
            return this;
        }

        public ResponseEntity<T> build() {
            ResponseEntity<T> responseEntity = new ResponseEntity<T>();
            responseEntity.setSuccess(this.isSuccess);
            responseEntity.setCode(this.code);
            responseEntity.setMessage(this.message);
            responseEntity.setResult(this.result);
            return responseEntity;
        }
    }

}
