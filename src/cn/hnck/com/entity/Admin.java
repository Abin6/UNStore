package cn.hnck.com.entity;

/**
 * 
 * ClassName: Admin
 * 
 * @Description: ����Ա
 * @author XHChen
 * @date 2018��11��20�� ����9:46:28
 */
public class Admin {

	private int id; // ����Ա����

	private String AdminName; // ����Ա����

	private String AdminPassword; // ����

	private String email; // ע������

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdminName() {
		return AdminName;
	}

	public void setAdminName(String adminName) {
		AdminName = adminName;
	}

	public String getAdminPassword() {
		return AdminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		AdminPassword = adminPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
