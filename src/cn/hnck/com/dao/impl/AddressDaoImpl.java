package cn.hnck.com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.hnck.com.dao.AddressDao;
import cn.hnck.com.entity.ShippingAddress;

public class AddressDaoImpl implements AddressDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	/**
	 * ��ӵ�ַ
	 */
	public int AddAddress(ShippingAddress address) throws Exception {

		// ����dao�ӿڴ������ķ�װ����
		try {
			this.hibernateTemplate.saveOrUpdate(address);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

		return 0;
	}

	@Override
	/**
	 * ���µ�ַ
	 */
	public int UpdateAddress(ShippingAddress address) throws Exception {

		// ������µ�����
		try {
			this.hibernateTemplate.saveOrUpdate(address);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return 0;

	}

	@Override
	/**
	 * ɾ����ַ
	 */
	public int DeleteAddress(int id) throws Exception {

		// ����idɾ������
		try {
			// ����id�ҵ�����
			ShippingAddress as = hibernateTemplate.get(ShippingAddress.class,
					id);
			// ɾ������
			hibernateTemplate.delete(as);

			return 1;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return 0;

	}

	@Override
	/**
	 * ����id��ѯ��ַ
	 */
	public ShippingAddress FindAddressById(int addressID) throws Exception {

		return this.hibernateTemplate.get(ShippingAddress.class, addressID);

	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * ��ѯ��ַ
	 */
	public List<ShippingAddress> FindAllAddress(String entityName)
			throws Exception {

		return (List<ShippingAddress>) this.hibernateTemplate.find("from" + " "
				+ entityName);

	}

	@Override
	/**
	 * ������ݿ���Ϣ����
	 */
	public int realPage(String entityName) {

		return this.hibernateTemplate.find("from" + " " + entityName).size();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * ��ҳ
	 */
	public List<ShippingAddress> getByPage(String entityName, int pageNo, int pageSize, int real) {

		int begin = (pageNo - 1) * pageSize;

		int end = (pageNo) * pageSize;

		// bug�޸���ʾbug
		if (end > real) {
			end = real;
		}

		return (List<ShippingAddress>) this.hibernateTemplate.find("from" + " " + entityName).subList(begin, end);
	}
}