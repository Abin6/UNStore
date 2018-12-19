package cn.hnck.com.service;

import java.util.List;

import cn.hnck.com.entity.Card;

/**
 * 
 * ClassName: CardService
 * 
 * @Description: ��Ƭservice�ӿ�
 * @author XHChen
 * @date 2018��11��28�� ����10:24:03
 */
public interface CardService {

	// ��ѯ������Ƭ
	public List<Card> findAllCard(String flag, int pageNo, int pageSize)
			throws Exception;

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

	// ������ݿ���ҳ��
	public int maxSize(String flag) throws Exception;

}
