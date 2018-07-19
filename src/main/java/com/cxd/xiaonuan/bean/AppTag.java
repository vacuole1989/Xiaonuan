package com.cxd.xiaonuan.bean;

import com.gitee.sunchenbin.mybatis.actable.annotation.Column;
import com.gitee.sunchenbin.mybatis.actable.annotation.Table;
import com.gitee.sunchenbin.mybatis.actable.constants.MySqlTypeConstant;

import java.io.Serializable;

/**
 * @author cxd
 */
@Table(name = "app_tag")
public class AppTag implements Serializable {


    @Column(name = "app_id", type = MySqlTypeConstant.BIGINT, isKey = true, isAutoIncrement = true)
    private long appId;
    @Column(name = "app_secret", type = MySqlTypeConstant.VARCHAR, length = 20)
    private String appSecret;
    @Column(name = "push_key", type = MySqlTypeConstant.INT, length = 8,isNull = false)
    private int pushKey;
    @Column(name = "push_biz_id", type = MySqlTypeConstant.VARCHAR)
    private String pushBizId;



    public long getAppId() {
        return appId;
    }

    public AppTag setAppId(long appId) {
        this.appId = appId;
        return this;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public AppTag setAppSecret(String appSecret) {
        this.appSecret = appSecret;
        return this;
    }

    public int getPushKey() {
        return pushKey;
    }

    public AppTag setPushKey(int pushKey) {
        this.pushKey = pushKey;
        return this;
    }

    public String getPushBizId() {
        return pushBizId;
    }

    public AppTag setPushBizId(String pushBizId) {
        this.pushBizId = pushBizId;
        return this;
    }

}