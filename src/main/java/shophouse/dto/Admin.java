package shophouse.dto;

public class Admin {

	private int adminId;
	private String adminName;
	private long adminContact;
	private String adminEmail;
	private String adminPassword;
	public int getAdminId() {
		return adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public long getAdminContact() {
		return adminContact;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public void setAdminContact(long adminContact) {
		this.adminContact = adminContact;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminContact=" + adminContact
				+ ", adminEmail=" + adminEmail + ", adminPassword=" + adminPassword + "]";
	}
	
	
	
}
