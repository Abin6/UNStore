package cn.hnck.com.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.hnck.com.dto.ProductDTO;
import cn.hnck.com.entity.Product;
import cn.hnck.com.service.ProductService;
import cn.hnck.com.utils.UpLoadUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @ClassName: ProductAction
 * @Description: ģ��������װ����
 * @author XHChen
 * @date 2018-9-27 ����8:34:19
 * 
 */
public class ProductAction extends ActionSupport implements
		ModelDriven<ProductDTO> {

	private static final long serialVersionUID = 1L;
	// ����ģʽ
	private ProductDTO productDTO = new ProductDTO();
	private Product product;

	private List<Product> list;
	private Product updateProduct;

	// service IOC
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public ProductDTO getModel() {
		return productDTO;
	}

	// ������Ӧҳ��
	private HttpServletRequest request;

	// ͼƬ�ϴ�
	private File headImg;
	private String headImgFileName;
	private String headImgContentType;

	// ��ҳ
	private int page;
	private int maxPage;

	// �洢�û�����ʷ��Ϊ����
	private ArrayList<String> arrayList = new ArrayList<String>();

	// ��Ʒ�Ƽ�
	public String recommended() throws Exception {
		
		for (String proName : arrayList) {
			// ��ҳ����
			this.request = ServletActionContext.getRequest();

			int maxPage = this.productService.maxLikeSize(proName);

			int pageNo = 1;

			int pageSize = 5;

			if (page > 0) {
				pageNo = page;
			}

			list = this.productService.getLikeByPage(proName, pageNo, pageSize);

			// �ѷ��ص�ʵ��setAttribute��ҳ��
			ActionContext.getContext().put("list", list);

			request.setAttribute("page", pageNo);

			request.setAttribute("maxPage", maxPage);
		}

		return "recommendpro";
	}

	// �����Ʒ
	public String save() throws Exception {

		product = new Product();

		String imagePath = UpLoadUtils.upload(headImg, headImgFileName);

		product.setImageSrc(imagePath);
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());

		this.productService.AddProduct(product);

		return "findpro";
	}

	// �޸���Ʒ
	public String update() throws Exception {

		product = new Product();

		String imagePath = UpLoadUtils.upload(headImg, headImgFileName);

		product.setId(productDTO.getId());
		product.setImageSrc(imagePath);
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setPrice(productDTO.getPrice());

		this.productService.UpdateProduct(product);

		return "findpro";
	}

	// ɾ����Ʒ
	public String delete() throws Exception {

		this.productService.DeleteProduct(productDTO.getId());

		return "findpro";
	}

	// ����id��ѯ�û�
	public String FindProductById() throws Exception {

		updateProduct = this.productService.FindProductById(productDTO.getId());

		// �ѷ��ص�ʵ��setAttribute��ҳ��
		ActionContext.getContext().put("updateProduct", updateProduct);

		return "updatepro";
	}

	// ģ����ѯ��Ʒ
	public String query() throws Exception {

		product = new Product();

		// ��ȡ�ύ����������
		product.setName(productDTO.getName());

		if (product.getName() != null) {
			list = this.productService.getLike(product.getName());

			// �ѷ��ص�ʵ��setAttribute��ҳ��
			ActionContext.getContext().put("list", list);

			return "prolist";
		} else {
			return "findpro";
		}
	}

	// ģ����ѯ
	public String queryPage() throws Exception {

		// �洢�û���Ϊ����
		if (!arrayList.contains(productDTO.getName())&& !productDTO.getName().equals("")) {
			arrayList.clear();
			arrayList.add(productDTO.getName());
		}

		product = new Product();

		// ��ȡ�ύ����������
		product.setName(productDTO.getName());

		// ��ҳ����
		this.request = ServletActionContext.getRequest();

		int maxPage = this.productService.maxLikeSize(product.getName());

		int pageNo = 1;

		int pageSize = 5;

		if (page > 0) {
			pageNo = page;
		}

		list = this.productService.getLikeByPage(product.getName(), pageNo,
				pageSize);
		
		

		// �ѷ��ص�ʵ��setAttribute��ҳ��
		ActionContext.getContext().put("list", list);

		request.setAttribute("page", pageNo);

		request.setAttribute("maxPage", maxPage);

		return "prolist";
	}

	// ��ҳ��ʾ
	public String list() throws Exception {

		this.request = ServletActionContext.getRequest();

		int maxPage = this.productService.maxSize();

		int pageNo = 1;

		int pageSize = 5;

		if (page > 0) {
			pageNo = page;
		}

		list = this.productService.getByPage(pageNo, pageSize);

		// �ѷ��ص�ʵ��setAttribute��ҳ��
		ActionContext.getContext().put("list", list);

		request.setAttribute("page", pageNo);

		request.setAttribute("maxPage", maxPage);

		return "prolist";
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	public Product getUpdateProduct() {
		return updateProduct;
	}

	public void setUpdateProduct(Product updateProduct) {
		this.updateProduct = updateProduct;
	}

	public File getHeadImg() {
		return headImg;
	}

	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}

	public String getHeadImgFileName() {
		return headImgFileName;
	}

	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}

	public String getHeadImgContentType() {
		return headImgContentType;
	}

	public void setHeadImgContentType(String headImgContentType) {
		this.headImgContentType = headImgContentType;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

}
