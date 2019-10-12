package br.com.fiap.deschateie.exception;

import java.time.LocalDate;

import lombok.Data;
@Data
public class ErrorMessage {
	
	private LocalDate timestamp;
    private String message;
    
    
    public ErrorMessage(LocalDate now, String erroMessageDescription) {
		// TODO Auto-generated constructor stub
    	this.timestamp=now;
    	this.message=erroMessageDescription;
	}


	public ErrorMessage() {
		super();
	}



	public LocalDate getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

    
    
}
