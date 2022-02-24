package com.sol.demoecom.common;

public class ResponseSuccess<T> {
    private boolean success = true;
    private T data;

    public ResponseSuccess(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public ResponseSuccess(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}