package accounting.model;

public class Posting {
	
	
	private String accountID ;
	private String postingID;
	private String postingType;
	private String amount;
	private String created_At;
	
	
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	
	public void setPostingID(String postingID) {
		this.postingID = postingID;
	}
	
	public void setPostingType(String postingType) {
		this.postingType = postingType;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public void setCreated_At(String created_At) {
		this.created_At = created_At;
	}
	
	public String getAccountID() {
		return accountID;
	}
	
	public String getPostingID() {
		return postingID;
	}
	
	public String getPostingType() {
		return postingType;
	}
	public String getAmount() {
		return amount;
	}
	
	public String getCreatedAt() {
		return created_At;
	}
}
