package cn.hnck.com.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.hnck.com.dao.RetrieveDao;
import cn.hnck.com.entity.Card;

/**
 * 
 * ClassName: RetrieveDaoImpl
 * 
 * @Description: ����վdaoʵ��
 * @author XHChen
 * @date 2018��12��1�� ����2:41:55
 */
public class RetrieveDaoImpl implements RetrieveDao {

	// ע��HibernateTemplateģ��
	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 
	 * @param flag
	 *            ״̬
	 * @Description: ����card��flag
	 * @param @param i
	 * @return void
	 * @throws
	 * @author XHChen
	 * @date 2018��12��1�� ����3:04:16
	 */
	private void updateCardFlag(int i, String flag) {

		try {
			// �ҵ�card
			Card card = this.hibernateTemplate.get(Card.class, i);
			// �ı���Ƭ״̬
			card.setFlag(flag);
			// ������Ƭ
			this.hibernateTemplate.update(card);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
	}

	@Override
	/**
	 * �Ƶ�����վ
	 */
	public void revertCard(int[] checkList, String flag) throws Exception {

		try {
			// �ı���Ƭ״̬
			for (int i : checkList) {
				updateCardFlag(i, flag);
			}

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
	}

	@Override
	/**
	 * ��ѯ�Ƶ�����վ��card
	 */
	public List<Card> findRevertCard(String flag, int pageNo, int pageSize,
			int real) throws Exception {

		int begin = (pageNo - 1) * pageSize;

		int end = (pageNo) * pageSize;

		// bug�޸���ʾbug
		if (end > real) {
			end = real;
		}

		try {
			// ��ѯ״̬Ϊflag��card
			@SuppressWarnings("unchecked")
			List<Card> cardList = this.hibernateTemplate.find(
					"from Card c where c.flag = ?", flag).subList(begin, end);

			return cardList;
		} catch (Exception e) {
			// ���������Ϣ
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	/**
	 * ɾ������վ����Ƭ��Ϣ
	 */
	public void deleteRevertCard(int id) throws Exception {

		try {
			// �ҵ�ɾ���Ŀ�Ƭ
			Card entity = this.hibernateTemplate.get(Card.class, id);
			// ɾ����Ƭ
			this.hibernateTemplate.delete(entity);
		} catch (Exception e) {
			// ���������Ϣ
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
	}

	@Override
	/**
	 * ��Ƭ��ԭ
	 */
	public void reductionCard(int[] boxList, String flag) throws Exception {

		try {
			for (int i : boxList) {
				// ��������״̬��־
				updateCardFlag(i, flag);
			}
		} catch (Exception e) {
			// ���������Ϣ
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}

	}

	@Override
	public List<Card> searchCard(String name, String flag) throws Exception {

		// ��дsql���
		String sql = "from Card c where c.name like ? and c.flag = ?";
		try {

			@SuppressWarnings("unchecked")
			List<Card> cards = this.hibernateTemplate.find(sql, new Object[] {
					"%" + name + "%", flag });

			return cards;
		} catch (Exception e) {
			// ���������Ϣ
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public int realPage(String entity, String flag) throws Exception {

		return this.hibernateTemplate.find(
				"from" + " " + entity + " where flag=" + flag).size();
	}

}
