package com.app.util;
import com.app.model.LoginModel;
public class LoginResponseBody {

    
    Boolean authenticated;

    
    String token;


	private LoginModel login;
    String message;

    public LoginResponseBody() {
    }

	public Boolean getAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(Boolean authenticated) {
		this.authenticated = authenticated;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LoginModel getLogin() {
		return login;
	}

	public void setLogin(LoginModel login) {
		this.login = login;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LoginResponseBody(Boolean authenticated, String token,
			LoginModel login, String message) {
		super();
		this.authenticated = authenticated;
		this.token = token;
		this.login = login;
		this.message = message;
	}

	public LoginResponseBody(Boolean authenticated, String token,
			LoginModel login) {
		super();
		this.authenticated = authenticated;
		this.token = token;
		this.login = login;
	}

	public LoginResponseBody(Boolean authenticated, String token, String message) {
		super();
		this.authenticated = authenticated;
		this.token = token;
		this.message = message;
	}

	
    
}