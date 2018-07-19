package com.cxd.xiaonuan.dto;

import java.io.Serializable;

public class ResponseJSON implements Serializable {

    private String error;
    private String message;
    private String path;
    private int status;
    private long timestamp;


    public ResponseJSON(String error, String message, String path, int status, long timestamp) {
        this.error = error;
        this.message = message;
        this.path = path;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public ResponseJSON setError(String error) {
        this.error = error;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseJSON setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getPath() {
        return path;
    }

    public ResponseJSON setPath(String path) {
        this.path = path;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public ResponseJSON setStatus(int status) {
        this.status = status;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public ResponseJSON setTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}
