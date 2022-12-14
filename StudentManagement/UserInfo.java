

public class UserInfo {
    
    private String UserName;
	private String Password; 

    
    public UserInfo(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    public String getUserName(){
		return UserName;
	}

	public void setUserName(String UserName){
		this.UserName = UserName;
	}

	public String getPassword(){
		return Password;
	}

	public void setPassword(String Password){
		this.Password = Password;
	}
}
