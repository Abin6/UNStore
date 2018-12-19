package cn.hnck.com.action.card;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.hnck.com.dto.CardDTO;
import cn.hnck.com.utils.DbToExcel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * ClassName: UploadAction
 * 
 * @Description: ������Ƭ
 * @author XHChen
 * @date 2018��12��3�� ����9:20:22
 */
public class UploadAction extends ActionSupport implements ModelDriven<CardDTO> {

	private static final long serialVersionUID = 1L;

	private CardDTO cardDTO = new CardDTO();

	@Override
	public CardDTO getModel() {

		return cardDTO;
	}

	private File file; // �ϴ��ļ�����

	private String fileContentType; // �ϴ��ļ���������

	private String fileFileName; // �ϴ��ļ���

	public String up() throws Exception {

		// ��ȡʵ�ʴ���ϴ��ļ����ļ���
		String path = ServletActionContext.getServletContext().getRealPath(
				"/upload");

		// ������·��
		File newPath = new File(path, fileFileName);

		// ����·��
		FileUtils.copyFile(file, newPath);

		// ���ù������ϴ��ļ�
		DbToExcel.excelToDb(path + "/" + fileFileName, "card",
				"(name,sex,department,mobile,phone,email,address)", 7);

		return "lsuccess";
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

}
