package cn.hnck.com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.hnck.com.dao.AdminDao;
import cn.hnck.com.entity.Admin;

/**
 * 
 * ClassName: AdminDaoImpl
 * 
 * @Description: ����Ա���ݲ���ʵ��
 * @author XHChen
 * @date 2018��11��21�� ����9:58:01
 */
public class AdminDaoImpl implements AdminDao {

	// ע��HibernateTemplate
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	/**
	 * ��ѯ����Ա
	 */
	public List<Admin> findAdmin(Admin admin) throws Exception {

		@SuppressWarnings("unchecked")
		List<Admin> list = this.hibernateTemplate.findByExample(admin);

		return list;
	}

	@Override
	public void insertAdmin(Admin admin) throws Exception {

		this.hibernateTemplate.save(admin);

	}

}
