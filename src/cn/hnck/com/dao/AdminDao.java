package cn.hnck.com.dao;

import java.util.List;

import cn.hnck.com.entity.Admin;

/**
 * 
 * ClassName: AdminDao
 * 
 * @Description: ����Ա���ݲ���
 * @author XHChen
 * @date 2018��11��21�� ����9:49:24
 */
public interface AdminDao {

	// ��ѯ����Ա
	public List<Admin> findAdmin(Admin admin) throws Exception;

	// ע��
	public void insertAdmin(Admin admin) throws Exception;

}
