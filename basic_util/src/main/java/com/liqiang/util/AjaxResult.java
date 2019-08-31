package com.liqiang.util;

/**
 * Ajax请求的返回内容:增删改
 *    success:成功与否
 *    message:失败原因
 */
public class AjaxResult {

    private boolean success = true;
    private String message = "操作成功!";

    public boolean isSuccess() {
        return success;
    }

    //链式编程,设置完成后自己对象返回,让AjaxResult.me().setMessage("xxx")后仍然是一个AjaxResult对象，所以可以继续点方法
    public AjaxResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AjaxResult setMessage(String message) {
        this.message = message;
        return this;
    }

    //默认成功
    public AjaxResult() {
    }

    //失败调用
    public AjaxResult(String message) {
        this.success = false;
        this.message = message;
    }

    //提前创建好对象，不用每次使用都new  这里提供me方法，AjaxResult.me()就能使用
    public static AjaxResult me(){
        return new AjaxResult();
    }

    public static void main(String[] args) {//为什么要main方法呢
        AjaxResult.me().setMessage("xxx").setSuccess(false);
    }
}
