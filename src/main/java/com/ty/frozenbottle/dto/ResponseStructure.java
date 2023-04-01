package com.ty.frozenbottle.dto;

public class ResponseStructure<T> {
	private int status;
	private String message;
	private T data;

	public ResponseStructure() {
		super();
	}

	public ResponseStructure(int status, String message, T data) {
		super();
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseStructure [status=" + status + ", message=" + message + ", data=" + data + "]";
	}

}
