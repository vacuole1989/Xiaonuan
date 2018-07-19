package com.cxd.xiaonuan.dto;


import java.io.Serializable;

public class ResultDto implements Serializable{
    private Object code;
    private JSONResult data;

    public Object getCode() {
        return code;
    }

    public ResultDto setCode(Object code) {
        this.code = code;
        return this;
    }

    public JSONResult getData() {
        return data;
    }

    public ResultDto setData(JSONResult data) {
        this.data = data;
        return this;
    }
}
