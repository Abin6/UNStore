package cn.hnck.com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.hnck.com.dao.ProductDao;
import cn.hnck.com.entity.Product;

/**
 * 
 * @ClassName: ProductDaoImpl
 * @Description: ��Ʒ���ݲ�ʵ����
 * @author XHChen
 * @date 2018-9-27 ����8:22:03
 * 
 */
public class ProductDaoImpl implements ProductDao {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	/**
	 * �����Ʒ
	 */
	public int AddProduct(Product product) throws Exception {

		// ����dao�ӿڴ������ķ�װ����
		try {
			this.hibernateTemplate.saveOrUpdate(product);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

		return 0;
	}

	@Override
	/**
	 * ������Ʒ
	 */
	public int UpdateProduct(Product product) throws Exception {

		// ����dao�ӿڴ������ķ�װ����
		try {
			this.hibernateTemplate.saveOrUpdate(product);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

		return 0;
	}

	@Override
	/**
	 * ɾ����Ʒ
	 */
	public int DeleteProduct(int ProductId) throws Exception {

		// ����idɾ������
		try {
			// ����id�ҵ�����
			Product product = hibernateTemplate.get(Product.class, ProductId);
			// ɾ������
			hibernateTemplate.delete(product);
			return 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}

		return 0;
	}

	@Override
	/**
	 * ����id��ѯ��Ʒ
	 */
	public Product FindProductById(int ProductId) throws Exception {

		return this.hibernateTemplate.get(Product.class, ProductId);

	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * ��ѯ������Ʒ
	 */
	public List<Product> FindAllProduct(String entityName) throws Exception {

		return (List<Product>) this.hibernateTemplate.find("from" + " "
				+ entityName);

	}

	@Override
	/**
	 * ģ����ѯ��Ʒ
	 */
	public List<Product> getLike(String likeName) throws Exception {

		@SuppressWarnings("unchecked")
		List<Product> list = this.hibernateTemplate.find(
				"from Product p where p.name like ?", "%" + likeName + "%");

		return list;
	}

	@Override
	/**
	 * ������ݿ���Ϣ����
	 */
	public int realPage(String entityName) throws Exception {

		return this.hibernateTemplate.find("from" + " " + entityName).size();
	}

	@Override
	/**
	 * ������ݿ���Ϣ����
	 */
	public int realLikePage(String likeName) throws Exception {

		return this.hibernateTemplate.find(
				"from Product p where p.name like ?", "%" + likeName + "%")
				.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * ���ݿ��������ݷ�ҳ
	 */
	public List<Product> getByPage(String entityName, int pageNo, int pageSize,
			int real) throws Exception {

		int begin = (pageNo - 1) * pageSize;

		int end = (pageNo) * pageSize;

		// bug�޸���ʾbug
		if (end > real) {
			end = real;
		}

		return (List<Product>) this.hibernateTemplate.find(
				"from" + " " + entityName).subList(begin, end);
	}

	/**
	 * 
	 * @Description: ģ����ѯ�������ݷ�ҳ
	 * @param @param entityName
	 * @param @param pageNo
	 * @param @param pageSize
	 * @param @param real
	 * @param @return
	 * @return List<Product>
	 * @throws
	 * @author XHChen
	 * @date 2018��11��21�� ����6:28:12
	 */
	public List<Product> getLikeByPage(String likeName, int pageNo,
			int pageSize, int real) throws Exception {

		int begin = (pageNo - 1) * pageSize;

		int end = (pageNo) * pageSize;

		// bug�޸���ʾbug
		if (end > real) {
			end = real;
		}

		@SuppressWarnings("unchecked")
		List<Product> list = this.hibernateTemplate.find(
				"from Product p where p.name like ?", "%" + likeName + "%")
				.subList(begin, end);

		return list;
	}

}
