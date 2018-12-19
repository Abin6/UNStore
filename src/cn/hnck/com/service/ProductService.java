package cn.hnck.com.service;

import java.util.List;

import cn.hnck.com.entity.Product;

/**
 * 
 * @ClassName: ProductService
 * @Description: ��Ʒ�����
 * @author XHChen
 * @date 2018-9-27 ����8:16:00
 * 
 */
public interface ProductService {

	// �����Ʒ
	public boolean AddProduct(Product product) throws Exception;

	// ������Ʒ
	public boolean UpdateProduct(Product product) throws Exception;

	// ɾ����Ʒ
	public boolean DeleteProduct(int ProductId) throws Exception;

	// ����id��ѯ��Ʒ
	public Product FindProductById(int ProductID) throws Exception;

	// ��ѯ������Ʒ
	public List<Product> FindAllProduct() throws Exception;
	
	// ģ����ѯ��Ʒ
	public List<Product> getLike(String likeName) throws Exception;
	
	// ������ݿ�����
	public int maxSize() throws Exception;
	
	// ������ݿ�ģ����Ϣ����
	public int maxLikeSize(String likeName) throws Exception;

	// ��ѯ������Ʒ����ҳ
	public List<Product> getByPage(int pageNo, int pageSize) throws Exception;
	
	// ģ����ѯ������Ʒ����ҳ
	public List<Product> getLikeByPage(String likeName, int pageNo, int pageSize) throws Exception;

}
