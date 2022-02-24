package com.sol.demoecom.common;

public class ResponseFail<T> {
    private boolean success = false;
    private String error;

    public ResponseFail(String error) {
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
