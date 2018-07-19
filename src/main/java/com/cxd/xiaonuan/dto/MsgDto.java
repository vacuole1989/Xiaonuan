package com.cxd.xiaonuan.dto;

import java.io.Serializable;

public class MsgDto implements Serializable {
    private String uid;
    private String content;

    public String getUid() {
        return uid;
    }

    public MsgDto setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getContent() {
        return content;
    }

    public MsgDto setContent(String content) {
        this.content = content;
        return this;
    }
}
