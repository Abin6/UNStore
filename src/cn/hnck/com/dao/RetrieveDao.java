package cn.hnck.com.dao;

import java.util.List;

import cn.hnck.com.entity.Card;

/**
 * 
 * ClassName: RetrieveDao
 * 
 * @Description: ����վdao
 * @author XHChen
 * @date 2018��12��1�� ����2:41:10
 */
public interface RetrieveDao {

	// �Ƶ�����վ
	public void revertCard(int[] checkList, String flag) throws Exception;

	// ��ѯ����վ
	public List<Card> findRevertCard(String flag, int pageNo, int pageSize,
			int real) throws Exception;

	// ɾ����Ƭ��Ϣ
	public void deleteRevertCard(int id) throws Exception;

	// �ظ�����վ����
	public void reductionCard(int[] boxList, String flag) throws Exception;

	// ģ����ѯ
	public List<Card> searchCard(String name, String flag) throws Exception;

	// ������ݿ����ҳ��
	public int realPage(String entity, String flag) throws Exception;

}
