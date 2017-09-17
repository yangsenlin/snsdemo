package com.ysl.snsDemo.controller;

import com.ysl.snsDemo.utils.ResultCode;

public class JsonResult {
	
	private int code;
	private String message;
	private Object data;
	
	public JsonResult() {
		this(ResultCode.SUCCESS,"成功！");
    }
	
	public JsonResult(ResultCode code) {  
        this(code,code.getMsg());  
    }
	
	public JsonResult(ResultCode code, String message) {  
        this.setCode(code);  
        this.setMessage(message);  
    }
	
	public JsonResult(ResultCode code, String message, Object data) {  
        this.setCode(code);  
        this.setMessage(message);  
        this.setData(data);  
    }

	public int getCode() {
		return code;
	}

	public void setCode(ResultCode code) {
		this.code = code.getCode();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
