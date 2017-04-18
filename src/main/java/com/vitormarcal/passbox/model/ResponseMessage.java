package com.vitormarcal.passbox.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseMessage {
	
	public enum Type {
		SUCCESS, WARNING, DANGER, INFO;
	}
	
	private Type type;
	private String message;
	private String code;
	
	private List<Error> errors = new ArrayList<>();

	public ResponseMessage(Type type, String message) {
		super();
		this.type = type;
		this.message = message;
	}

	public ResponseMessage(Type type, String message, String code) {
		super();
		this.type = type;
		this.message = message;
		this.code = code;
	}

	public Type getType() {
		return type;
	}

	public String getMessage() {
		return message;
	}

	public String getCode() {
		return code;
	}

	public List<Error> getErrors() {
		return errors;
	}
	
	public static ResponseMessage success(String message){
		return new ResponseMessage(Type.SUCCESS, message);
	}
	public static ResponseMessage warning(String message){
		return new ResponseMessage(Type.WARNING, message);
	}
	public static ResponseMessage info(String message){
		return new ResponseMessage(Type.INFO, message);
	}
	public static ResponseMessage danger(String message){
		return new ResponseMessage(Type.DANGER, message);
	}
	
	

}
