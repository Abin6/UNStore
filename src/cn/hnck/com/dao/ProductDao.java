package cn.hnck.com.dao;

import java.util.List;

import cn.hnck.com.entity.Product;

/**
 * 
 * @ClassName: ProductDao
 * @Description: ��Ʒ���ݲ�ӿ�
 * @author XHChen
 * @date 2018-9-27 ����7:44:32
 * 
 */
public interface ProductDao {

	// �����Ʒ
	public int AddProduct(Product product) throws Exception;

	// �޸���Ʒ
	public int UpdateProduct(Product product) throws Exception;

	// ɾ����Ʒ
	public int DeleteProduct(int ProductId) throws Exception;

	// ����id��ѯ��Ʒ
	public Product FindProductById(int ProductId) throws Exception;

	// ��ѯ������Ʒ
	public List<Product> FindAllProduct(String entityName) throws Exception;
	
	// ģ����ѯ��Ʒ
	public List<Product> getLike(String likeName) throws Exception;

	// ������ݿ���Ϣ����
	public int realPage(String entityName) throws Exception;
	
	// ģ����Ϣ����
	public int realLikePage(String likeName) throws Exception;

	// ��ѯ������Ʒ����ҳ
	public List<Product> getByPage(String entityName, int pageNo, int pageSize, int real) throws Exception;
	
	// ģ����ѯ������Ʒ����ҳ
	public List<Product> getLikeByPage(String likeName, int pageNo, int pageSize, int real) throws Exception;

}
