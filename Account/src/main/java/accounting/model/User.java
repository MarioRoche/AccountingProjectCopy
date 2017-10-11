package accounting.model;

public class User {
	private String user_id;
	private String phone_number;
	private String emailID;
	private String created_At;
	
	
	public void setUserID(String user_id) {
		this.user_id = user_id;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phone_number = phoneNumber;
	}
	
	public void setEmailID(String emailID) {
		this.emailID=emailID;
	}
	
	public void setCreatedAt(String created_At) {
		this.created_At = created_At;
	}
	
	public String getUserID() {
		return user_id;
	}
	
	public String getPhoneNumber() {
		return phone_number;
	}
	
	public String getEmailID() {
		 return emailID;
	}
	
	public String getCreatedAt() {
		return created_At;
	}
}
