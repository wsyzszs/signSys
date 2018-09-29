package com.qfedu.sign.vo;

import java.util.List;

public class TableVo<T> {
    private int code;
    private String msg;
    private int count;
    private List<T> data;

    public int getCode() {
        return code;
    }

    public TableVo setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public TableVo setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public int getCount() {
        return count;
    }

    public TableVo setCount(int count) {
        this.count = count;
        return this;
    }

    public List<T> getData() {
        return data;
    }

    public TableVo setData(List<T> data) {
        this.data = data;
        return this;
    }

    public TableVo() {
    }

    public TableVo(int code, String msg, int count, List<T> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public TableVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> TableVo setOK(List<T> data,Integer count){
        return new TableVo(0,"done!",count,data);
    }

    public static TableVo setError(){
        return new TableVo(1,"Error");
    }
}
