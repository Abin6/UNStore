package cn.hnck.com.dto;

/**
 * 
 * ClassName: AdminDTO
 * 
 * @Description: ��װ����
 * @author XHChen
 * @date 2018��11��21�� ����9:16:50
 */
public class AdminDTO {

	private int id; // ����Ա����

	private String AdminName; // ����Ա����

	private String AdminPassword; // ����

	private String SurePassword; // ȷ������

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

	public String getSurePassword() {
		return SurePassword;
	}

	public void setSurePassword(String surePassword) {
		SurePassword = surePassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
