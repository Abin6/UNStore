package cn.hnck.com.service;

import java.util.List;

import cn.hnck.com.entity.Admin;

/**
 * 
 * ClassName: AdminService
 * 
 * @Description: ����Ա����ӿ�
 * @author XHChen
 * @date 2018��11��21�� ����9:42:00
 */
public interface AdminService {

	// ��ѯ����Ա
	public List<Admin> findAdmin(Admin admin) throws Exception;

	// ע��
	public void insertAdmin(Admin admin) throws Exception;

}
