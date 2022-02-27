package com.test.domain.common;

import java.io.Serializable;

/**
 * @author a
 * 返回结果的封装
 */
public class AjaxResult implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int CODE_SUCCESS = 200;
	public static final int CODE_FAILED = 1;
	public static final int CODE_PARAM_ERROR = 304;
	//系统内部错误
	public static final int CODE_SYSTEM_ERROR = 500;

	/**
	 * ajaxResult属性
	 */
	public static final String KEY_MESSAGE = "message";
	public static final String KEY_CODE = "code";
	public static final String KEY_DATA = "data";
	public static final String KEY_SUCCESS = "success";

	/**
	 * 网络连接异常，或云端接口返回为空
	 */
	public static final int CODE_NET_WORK_ERROR = 6;

	private int code;
	private String message;
	private Object data;

	public AjaxResult() {
	}

	public AjaxResult(int code, Object data, String message) {
		this.code = code;
		this.message = message;
		this.data = (data == null?new Object():data);
	}

	public AjaxResult(int code, String message) {
		this.code = code;
		this.message = message;
		this.data = "";
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

	public int getCode(){return code;}

	public boolean isSuccess() {
		return CODE_SUCCESS == code;
	}

	public static final AjaxResult success() {
		return new AjaxResult(CODE_SUCCESS, "", "");
	}

	public static final AjaxResult success(Object data) {
		return new AjaxResult(CODE_SUCCESS, data, "");
	}

	public static final AjaxResult success(String msg) {
		return new AjaxResult(CODE_SUCCESS, "", msg);
	}

	public static final AjaxResult success(Object data, String message) {
		return new AjaxResult(CODE_SUCCESS, data, message);
	}

	public static final AjaxResult failed() {
		return new AjaxResult(CODE_FAILED, "", "");
	}

	public static final AjaxResult failed(String message) {
		return new AjaxResult(CODE_FAILED, "", message);
	}

	public static final AjaxResult failed(Object data, String message) {
		return new AjaxResult(CODE_FAILED, data, message);
	}

	public static final AjaxResult failed(int code, String message) {
		return new AjaxResult(code, message);
	}
	
	public static final AjaxResult failed(Object data) {
		return new AjaxResult(CODE_FAILED, data, "");
	}

	@Override
	public String toString() {
		return "AjaxResult{" +
				"code=" + code +
				", message='" + message + '\'' +
				", data=" + data +
				'}';
	}
}
