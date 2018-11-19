package service;

import org.springframework.stereotype.Service;

@Service
public class MessageProviderService {
	
	private String message;
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

}
