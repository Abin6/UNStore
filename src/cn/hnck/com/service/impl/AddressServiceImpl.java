package cn.hnck.com.service.impl;

import java.util.List;

import cn.hnck.com.dao.AddressDao;
import cn.hnck.com.entity.ShippingAddress;
import cn.hnck.com.service.AddressService;

public class AddressServiceImpl implements AddressService {

	// ����dao�ӿڶ���
	private AddressDao addressDao;

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	/**
	 * ��ӵ�ַ
	 */
	public boolean AddAddress(ShippingAddress address) throws Exception {

		int flag = this.addressDao.AddAddress(address);

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * ���µ�ַ
	 */
	public boolean UpdateAddress(ShippingAddress address) throws Exception {

		int flag = this.addressDao.UpdateAddress(address);

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * ɾ����ַ
	 */
	public boolean DeleteAddress(int id) throws Exception {

		int flag = this.addressDao.DeleteAddress(id);

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * ����id��ѯ��ַ
	 */
	public ShippingAddress FindAddressById(int addressID) throws Exception {

		return this.addressDao.FindAddressById(addressID);
	}

	@Override
	/**
	 * ��ѯ��ַ
	 */
	public List<ShippingAddress> FindAllAddress() throws Exception {

		return addressDao.FindAllAddress("ShippingAddress");

	}
	
	@Override
	/**
	 * ������ݿ���Ϣ����
	 */
	public int maxSize() throws Exception {

		int count = 0;

		int maxPage = 0;

		count = this.addressDao.realPage("ShippingAddress");

		maxPage = (count + 4) / 5;

		return maxPage;
	}

	@Override
	/**
	 * ��ҳ
	 */
	public List<ShippingAddress> getByPage(int pageNo, int pageSize) {

		int real = this.addressDao.realPage("ShippingAddress");

		return this.addressDao.getByPage("ShippingAddress", pageNo, pageSize, real);
	}

}
