package com.zhao.rpc.rpc_test;

import java.io.Serializable;
import java.util.Date;

/**
 * @创建人 zhaohuan
 * @邮箱 1101006260@qq.com
 * @创建时间 2018-06-27 20:30
 * @描述
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private Date time;
    private String userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getTime() {
        return time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", time=" + time +
                ", userId='" + userId + '\'' +
                '}';
    }
}
