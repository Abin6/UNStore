package cn.hnck.com.dao;

import java.util.List;

import cn.hnck.com.entity.Card;

/**
 * 
 * ClassName: CardDao
 * 
 * @Description: ��Ƭdao�ӿ�
 * @author XHChen
 * @date 2018��11��28�� ����10:29:28
 */
public interface CardDao {

	// ��ѯ������Ƭ
	public List<Card> findAllCard(String entityName, String flag, int pageNo,
			int pageSize, int real) throws Exception;

	// �����Ƭ
	public void insertCard(Card card) throws Exception;

	// ��ѯ��Ƭ
	public Card findCardById(int id) throws Exception;

	// �������ݿ���Ϣ
	public void updateCard(Card card) throws Exception;

	// ɾ����Ƭ��Ϣ
	public void deleteCard(int id) throws Exception;

	// ɾ����ѡ��Ƭ��Ϣ
	public void delCardList(int[] boxList) throws Exception;

	// ģ����ѯ��Ƭ
	public List<Card> searchByLike(String name, String flag) throws Exception;

	// ������ݿ���Ϣ��ҳ��
	public int realPage(String entity, String flag) throws Exception;

}
