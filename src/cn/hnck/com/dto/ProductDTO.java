package cn.hnck.com.dto;

import java.io.File;

/**
 * 
 * @ClassName: ProductDTO
 * @Description: ��Ʒ��װ����
 * @author XHChen
 * @date 2018-9-27 ����8:32:22
 * 
 */
public class ProductDTO {

	private int id; // ��Ʒid����

	private String name; // ��Ʒ����

	private double price; // ��Ʒ�۸�

	private String description; // ��Ʒ����

	private File file; // ��Ƭ��ַ

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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
