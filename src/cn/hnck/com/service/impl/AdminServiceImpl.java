package cn.hnck.com.service.impl;

import java.util.List;

import cn.hnck.com.dao.AdminDao;
import cn.hnck.com.entity.Admin;
import cn.hnck.com.service.AdminService;

/**
 * 
 * ClassName: AdminImpl
 * 
 * @Description: ����Ա����ʵ��
 * @author XHChen
 * @date 2018��11��21�� ����9:45:26
 */
public class AdminServiceImpl implements AdminService {

	// ע��dao
	private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	/**
	 * ��ѯ����Ա
	 */
	public List<Admin> findAdmin(Admin admin) throws Exception {

		return this.adminDao.findAdmin(admin);
	}

	@Override
	public void insertAdmin(Admin admin) throws Exception {
		
		this.adminDao.insertAdmin(admin);
	}

}
