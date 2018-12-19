package cn.hnck.com.action.card;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.hnck.com.dto.CardDTO;
import cn.hnck.com.utils.DbToExcel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DownLoadAction extends ActionSupport implements ModelDriven<CardDTO> {

	private static final long serialVersionUID = 1L;

	private CardDTO cardDTO = new CardDTO();

	@Override
	public CardDTO getModel() {
		return cardDTO;
	}

	private String contentType; // ָ�������ļ�������,Ĭ��ֵΪ text/plain
	private long contentLength; // �����ص��ļ��Ĵ�С�����ֽ�Ϊ��λ

	// ���ԣ�contentDisposition��ָ���ļ����صĴ���ʽ����Ϊattachment��������ʽ���ᵯ���ļ�����Ի�����Ĭ�Ϸ�ʽ��
	// ���ʽ��attachment;filename="${fileName}
	private String contentDisposition; // ָ�������ļ������ط�ʽ����ָ�������ļ���Ĭ���ļ���
	private InputStream inputStream; // Action ���ṩ���ļ�����������Ĭ��ֵΪ inputStream

	private String fileName = "��Ƭ.xls"; // ָ�����ص��ļ���

	public String down() throws Exception {
		
		String[] fieldList = { "id", "name", "sex", "department", "mobile",
				"phone", "email", "address", "flag" };
		String[] titles = { "���", "����", "�Ա�", "��λ", "�ֻ�", "�绰", "��������", "��ַ",
				"��ע" };
		String file = "��Ƭ.xls";
		HttpSession session = ServletActionContext.getRequest().getSession();
		String condition = (String) session.getAttribute("condition");
		String order = (String) session.getAttribute("order");
		String sql = "";
		if (condition != null && !condition.equals("")) {
			sql = sql + " (name like '%" + condition + "%'";
			sql = sql + " or sex like '%" + condition + "%'";
			sql = sql + " or department like '%" + condition + "%'";
			sql = sql + " or mobile like '%" + condition + "%'";
			sql = sql + " or phone like '%" + condition + "%'";
			sql = sql + " or email like '%" + condition + "%'";
			sql = sql + " or address like '%" + condition + "%')";
		}

		// ȷ��������Ա������ֵ��ע�⣬��ЩֵҲ�����������ļ������ã���һ������������
		contentType = "application/octet-stream";// ָ��Ϊ�������͵��ļ�
		// ָ�����غ�Ҫ�����Ĭ���ļ���,��ͨ������ת����ʹ֧֮�ֺ����ļ���
		String name = java.net.URLEncoder.encode(fileName, "UTF-8");
		contentDisposition = "attachment;filename=" + name;

		ServletContext servletContext = ServletActionContext
				.getServletContext();

		String fileName2 = servletContext.getRealPath("/download/" + file);
		File downloadfile = new File(fileName2);
		if (!downloadfile.exists()) {
			System.out.println("������");
			downloadfile.getParentFile().mkdirs();
		}

		DbToExcel.dBToExcel("card", fieldList, titles, sql, order, fileName2);

		inputStream = new FileInputStream(fileName2);
		contentLength = inputStream.available();
		
		return "lsuccess";
	}

	public String getContentType() {
		return contentType;
	}

	public long getContentLength() {
		return contentLength;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public InputStream getInputStream() {
		return inputStream;
	}
}
