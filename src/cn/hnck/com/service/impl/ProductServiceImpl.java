package cn.hnck.com.service.impl;

import java.util.List;

import cn.hnck.com.dao.ProductDao;
import cn.hnck.com.entity.Product;
import cn.hnck.com.service.ProductService;

/**
 * 
 * @ClassName: ProductServiceImpl
 * @Description: ��Ʒ�����ʵ����
 * @author XHChen
 * @date 2018-9-27 ����8:20:30
 * 
 */
public class ProductServiceImpl implements ProductService {

	// ����dao�ӿڶ���
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	/**
	 * �����Ʒ
	 */
	public boolean AddProduct(Product product) throws Exception {

		int flag = this.productDao.AddProduct(product);

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * ������Ʒ
	 */
	public boolean UpdateProduct(Product product) throws Exception {

		int flag = this.productDao.UpdateProduct(product);

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * �h����Ʒ
	 */
	public boolean DeleteProduct(int ProductId) throws Exception {

		int flag = this.productDao.DeleteProduct(ProductId);

		if (flag == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	/**
	 * ͨ��id��ѯ��Ʒ
	 */
	public Product FindProductById(int ProductID) throws Exception {

		return this.productDao.FindProductById(ProductID);
	}

	@Override
	/**
	 * ��ѯ������Ʒ
	 */
	public List<Product> FindAllProduct() throws Exception {

		return this.productDao.FindAllProduct("Product");
	}

	@Override
	/**
	 * ģ����ѯ��Ʒ
	 */
	public List<Product> getLike(String likeName) throws Exception {

		return this.productDao.getLike(likeName);
	}

	@Override
	/**
	 * ������ݿ���Ϣ����
	 */
	public int maxSize() throws Exception {

		int count = 0;

		int maxPage = 0;

		count = this.productDao.realPage("Product");

		maxPage = (count + 4) / 5;

		return maxPage;
	}
	
	@Override
	/**
	 * ������ݿ�ģ����Ϣ����
	 */
	public int maxLikeSize(String likeName) throws Exception {

		int count = 0;

		int maxPage = 0;

		count = this.productDao.realLikePage(likeName);

		maxPage = (count + 4) / 5;

		return maxPage;
	}

	@Override
	/**
	 * ��ѯ������Ʒ����ҳ
	 */
	public List<Product> getByPage(int pageNo, int pageSize) throws Exception {

		int real = this.productDao.realPage("Product");

		return this.productDao.getByPage("Product", pageNo, pageSize, real);
	}

	@Override
	/**
	 * ģ����ѯ������Ʒ����ҳ
	 */
	public List<Product> getLikeByPage(String likeName, int pageNo, int pageSize)
			throws Exception {

		int real = this.productDao.realLikePage(likeName);
		
		return this.productDao.getLikeByPage(likeName, pageNo, pageSize, real);
	}

}
