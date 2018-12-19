package cn.hnck.com.action;

import java.util.List;

import cn.hnck.com.dto.AdminDTO;
import cn.hnck.com.entity.Admin;
import cn.hnck.com.service.AdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminLoginAction extends ActionSupport implements
		ModelDriven<AdminDTO> {

	private static final long serialVersionUID = 1L;
	// ���ҳ���װ������
	private AdminDTO adminDTO = new AdminDTO();
	// ����ʵ����
	private Admin admin;

	// ע��service ioc
	private AdminService adminService;

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@Override
	public AdminDTO getModel() {
		return adminDTO;
	}

	/**
	 * 
	 * @Description: ����Ա��½
	 * @param
	 * @return void
	 * @throws Exception
	 * @throws
	 * @author XHChen
	 * @date 2018��11��21�� ����10:10:52
	 */
	public String admin() throws Exception {

		// ����admin����
		admin = new Admin();

		// ����ҳ���װ��ֵ
		admin.setAdminName(adminDTO.getAdminName());
		admin.setAdminPassword(adminDTO.getAdminPassword());

		// ��ѯ���ݿ�
		List<Admin> list = this.adminService.findAdmin(admin);

		int size = list.size();

		if (size > 0) {
			// ����Ա����,������ҳ��
			ActionContext.getContext().put("AdminName", admin.getAdminName());

			return "success";
		} else {
			// ����Ա������,������ʾ��Ϣ
			String msg = "����Ա������!";
			ActionContext.getContext().put("msg", msg);

			// ���ص�½ҳ��
			return "msg";
		}
	}

	/**
	 * 
	 * @Description: �˳���½
	 * @param @return
	 * @return String
	 * @throws
	 * @author XHChen
	 * @date 2018��11��21�� ����11:51:22
	 */
	public String out() throws Exception {

		return "out";
	}

	/**
	 * 
	 * @Description: ����Աע��
	 * @param @return
	 * @param @throws Exception
	 * @return String
	 * @throws
	 * @author XHChen
	 * @date 2018��12��17�� ����1:36:40
	 */
	public String registered() throws Exception {

		// ����admin����
		admin = new Admin();

		// ����ƥ��
		if (adminDTO.getAdminName().equals("")){
			ActionContext.getContext().put("error", "�ǳƲ���Ϊ�գ�");

		} else if (adminDTO.getAdminPassword().equals("")) {
			ActionContext.getContext().put("error", "���벻��Ϊ�գ�");

		} else if (adminDTO.getSurePassword().equals("")) {
			ActionContext.getContext().put("error", "ȷ�����벻��Ϊ�գ�");

		} else if (adminDTO.getEmail().equals("")) {
			ActionContext.getContext().put("error", "���䲻��Ϊ�գ�");

		}else if (!adminDTO.getAdminPassword().equals(adminDTO.getSurePassword())) {
			ActionContext.getContext().put("error", "���벻ƥ�䣡");

		} else {
			admin.setAdminName(adminDTO.getAdminName());
			admin.setAdminPassword(adminDTO.getAdminPassword());
			admin.setEmail(adminDTO.getEmail());
	
			// ��ӹ���Ա
			adminService.insertAdmin(admin);
	
			// ��Ӧ��Ϣ
			ActionContext.getContext().put("msg", "ע��ɹ���");
	
			return "msg";
		}
			
		return "error";
	}
}
