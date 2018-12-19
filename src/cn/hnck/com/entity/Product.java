package cn.hnck.com.entity;

/**
 * 
 * @ClassName: Product
 * @Description: ��Ʒʵ����
 * @author XHChen
 * @date 2018-9-27 ����3:43:03
 * 
 */
public class Product {

	private int id; // ��Ʒid����

	private String name; // ��Ʒ����

	private String description; // ��Ʒ����

	private String imageSrc; // ��Ƭ��ַ

	private double price; // ��Ʒ�۸�

	// �޲ι��캯��
	public Product() {
		super();
	}

	// ������Ʒ����
	public Product(String name) {
		super();

		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageSrc() {
		return imageSrc;
	}

	public void setImageSrc(String imageSrc) {
		this.imageSrc = imageSrc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
