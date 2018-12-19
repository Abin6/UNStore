package cn.hnck.com.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

/**
 * 
 * @ClassName: UpLoadUtils
 * @Description: ͼƬ�ϴ�����
 * @author XHChen
 * @date 2018-9-28 ����8:04:33
 * 
 */
public class UpLoadUtils {

	private static final int BUFFER_SIZE = 16 * 1024;

	/**
	 * 
	* @Title: copy
	* @Description: ��ͼƬд�뵽���õ�·����
	* @param @param src
	* @param @param dst    �趨�ļ�
	* @return void    ��������
	* @throws
	 */
	private static void copy(File src, File dst) {

		InputStream in = null;
		OutputStream out = null;

		try {
			in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);

			out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);

			byte[] buffer = new byte[BUFFER_SIZE];

			while (in.read(buffer) > 0) {

				out.write(buffer);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static String getExtention(String fileName) {

		int pos = fileName.lastIndexOf(".");

		return fileName.substring(pos);

	}

	/**
	 * @param headImgFileName 
	 * 
	* @Title: upload
	* @Description: �ϴ�ͼƬ
	* @param @param src
	* @param @return    �趨�ļ�
	* @return String    ��������
	* @throws
	 */
	public static String upload(File src, String headImgFileName) {
		
		if (src == null)return "ͼƬΪ�գ�";
		
		String tempName = new Date().getTime() + getExtention(headImgFileName);
		
		// �õ�ͼƬ�����λ��(����root���õ�ͼƬ�����·����tomcat�µĸù�����)
		File imageFile = new File(ServletActionContext.getServletContext() .getRealPath("UploadImages") + "\\" + tempName);

		// ��ͼƬд�뵽�������õ�·����
		copy(src, imageFile);

		// �޸Ŀͻ�����ʾͼƬbug ʹ����Ե�ַ ֱ�ӷ����ļ��� mysql�洢���ļ���
		return tempName;
	}
}
