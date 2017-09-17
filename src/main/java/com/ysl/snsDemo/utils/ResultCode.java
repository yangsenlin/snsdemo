package com.ysl.snsDemo.utils;

public enum ResultCode {
	
	SUCCESS(200,"成功"),
	/** 发生异常 */  
    EXCEPTION(401, "发生异常"),
    /** 系统错误 */  
    SYS_ERROR(402, "系统错误"),
    /** 参数错误 */  
    PARAMS_ERROR(403, "参数错误 ");
	
	private ResultCode(int code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
	private int code;
	private String msg;
	
	public String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}
}
