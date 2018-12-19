package cn.hnck.com.service;

import java.util.List;

import cn.hnck.com.entity.Card;

/**
 * 
 * ClassName: RetrieveService
 * 
 * @Description: ����վservice
 * @author XHChen
 * @date 2018��12��1�� ����2:37:43
 */
public interface RetrieveService {

	// �Ƶ�����վ
	public void revertCard(int[] checkList, String flag) throws Exception;

	// ��ѯ����վ
	public List<Card> findRevertCard(String flag, int pageNo, int pageSize) throws Exception;

	// ɾ����Ƭ��Ϣ
	public void deleteRevertCard(int id) throws Exception;

	// ɾ������վ��Ƭ
	public void delListCard(int[] boxList) throws Exception;

	// �ָ�����վ����
	public void reductionCard(int[] boxList, String flag) throws Exception;

	// ģ����ѯ
	public List<Card> searchCard(String name, String flag) throws Exception;

	// ������ݿ����ҳ��
	public int maxSize(String falg) throws Exception;

}
