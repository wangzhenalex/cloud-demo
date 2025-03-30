package com.example.common;

import lombok.Data;

/**
 * @author zhenwang
 * @version 1.0
 * @time 2025/3/30 18:56
 * @description
 **/
@Data
public class R {
    private Integer code;
    private String msg;
    private Object data;

    public static R ok() {
        R r = new R();
        r.setCode(200);
        r.setMsg("success");
        return r;
    }
    public static R ok(Integer code) {
        R r = new R();
        r.setCode(code);
        r.setMsg("success");
        return r;
    }
    public static R ok(Integer code, String msg) {
        R r = new R();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static R error(int i, String s) {
        R r = new R();
        r.setCode(i);
        r.setMsg(s);
        return r;
    }
}
