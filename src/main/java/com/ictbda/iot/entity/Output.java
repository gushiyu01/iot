package com.ictbda.iot.entity;

import java.io.Serializable;

/**
 * @Author: Create by gsy
 * @Date: Create in 2020/6/4 15:08
 * @Description: 统一出参
 */
public class Output implements Serializable {
    private Integer code;
    private String msg;
    private Object object;

    public static Output build() {
        return new Output();
    }

    public static Output ok(String msg) {
        return new Output(200, msg, null);
    }

    public static Output ok(String msg, Object obj) {
        return new Output(200, msg, obj);
    }

    public static Output error(String msg) {
        return new Output(500, msg, null);
    }

    public static Output error(String msg, Object obj) {
        return new Output(500, msg, obj);
    }

    public Output() {
    }

    public Output(Integer code, String msg, Object object) {
        this.code = code;
        this.msg = msg;
        this.object = object;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Output{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", object=" + object +
                '}';
    }
}
