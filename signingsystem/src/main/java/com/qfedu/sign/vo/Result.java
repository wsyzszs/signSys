package com.qfedu.sign.vo;

public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public Result() {}

    public Result(Integer code, String msg,  Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public Result setData(Object data) {
        this.data = data;
        return this;
    }

    public static Result setOK(){
        return new Result(200,"",null);
    }

    public static Result setError(){
        return new Result(201,"",null);
    }

}
