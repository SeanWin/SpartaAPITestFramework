package pojo;

public class AuthenticationBody{
	private String username;
	private String password;;

	public AuthenticationBody(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}
}
