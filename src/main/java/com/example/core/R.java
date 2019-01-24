package com.example.core;

import java.util.HashMap;
import java.util.List;

/**
 * 接口返回
 *
 * @author chenzz
 */
public class R extends HashMap<String, Object> {

    private static final long serialVersionUID = 1L;

    private R() {
        put("code", 200);
        put("msg", "success");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok() {
        return new R();
    }

    //-------------------------------

    public R data(Object o) {
        return put("data", o);
    }

    //-----------------------
    public R dataRows(long total, long pageCount, List<?> rows) {
        put("total", total).put("pageCount", pageCount).put("rows", rows);
        return this;
    }
    //-----------------------

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
    //-----------------------

}
