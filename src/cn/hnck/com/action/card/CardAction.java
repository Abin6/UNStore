package cn.hnck.com.action.card;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.hnck.com.dto.CardDTO;
import cn.hnck.com.entity.Card;
import cn.hnck.com.service.CardService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * ClassName: CardAction
 * 
 * @Description: ��Ƭ����action
 * @author XHChen
 * @date 2018��11��28�� ����10:05:12
 */
public class CardAction extends ActionSupport implements ModelDriven<CardDTO> {

	private static final long serialVersionUID = 1L;

	private CardDTO cardDTO = new CardDTO();

	@Override
	public CardDTO getModel() {
		return cardDTO;
	}

	// ע��service ioc
	private CardService cardService;

	public void setCardService(CardService cardService) {
		this.cardService = cardService;
	}

	// ����ʵ����
	private Card card;

	// ��װcheckbox��id
	private int[] BoxList;

	// ��ҳ
	private int page;
	private int maxPage;

	// ����ҳ��
	private HttpServletRequest request;

	// ��ѯ���ݿ�������Ϣ
	public String list() throws Exception {

		// �������
		this.request = ServletActionContext.getRequest();

		// ������ݿ����ҳ��
		int maxPage = this.cardService.maxSize("0");

		// ���õ�ǰҳ��
		int pageNo = 1;

		// ����ÿҳ��Ϣ��
		int pageSize = 10;

		// ���µ�ǰҳ��
		if (page > 0) {
			pageNo = page;
		}

		// ����cardService������ѯ���ݿ�
		List<Card> cardList = this.cardService.findAllCard("0", pageNo, pageSize);

		// ��Ӧ���ݵ�ҳ��
		ActionContext.getContext().put("cardList", cardList);
		
		request.setAttribute("page", pageNo);

		request.setAttribute("maxPage", maxPage);

		return "clist";
	}

	// �����Ƭ
	public String insert() throws Exception {

		// ����ʵ����
		card = new Card();

		// ��װҳ������
		card.setName(cardDTO.getName());
		card.setSex(cardDTO.getSex());
		card.setDepartment(cardDTO.getDepartment());
		card.setMobile(cardDTO.getMobile());
		card.setPhone(cardDTO.getPhone());
		card.setEmail(cardDTO.getEmail());
		card.setAddress(cardDTO.getAddress());
		card.setFlag("0");

		// ����cardService������������
		this.cardService.insertCard(card);

		return "csave";

	}

	// ����id��ѯ����
	public String find() throws Exception {

		// ����cardService������ѯ����
		card = this.cardService.findCardById(cardDTO.getId());

		// ��Ӧ���ݵ�ҳ��
		ActionContext.getContext().put("card", card);

		return "cfind";

	}

	// �������ݿ���Ϣ
	public String update() throws Exception {

		// ����ʵ����
		card = new Card();

		// ��װҳ������
		card.setId(cardDTO.getId());
		card.setName(cardDTO.getName());
		card.setSex(cardDTO.getSex());
		card.setDepartment(cardDTO.getDepartment());
		card.setMobile(cardDTO.getMobile());
		card.setPhone(cardDTO.getPhone());
		card.setEmail(cardDTO.getEmail());
		card.setAddress(cardDTO.getAddress());
		card.setFlag("0");

		// ����cardService������������
		this.cardService.updateCard(card);

		return "csave";

	}

	// ɾ����Ƭ��Ϣ
	public String delete() throws Exception {

		// ����cardService����ɾ������
		this.cardService.deleteCard(cardDTO.getId());

		return "csave";

	}

	// ɾ����ѡ
	public String delList() throws Exception {

		// ����cardService����ɾ������
		this.cardService.delCardList(BoxList);

		return "csave";

	}

	// ģ����ѯ��Ƭ
	public String search() throws Exception {

		// ����cardService������ѯ����
		List<Card> cardList = this.cardService.searchByLike(cardDTO.getName(),
				"0");

		// ��Ӧ���ݵ�ҳ��
		ActionContext.getContext().put("cardList", cardList);

		return "clist";

	}

	public int[] getBoxList() {
		return BoxList;
	}

	public void setBoxList(int[] boxList) {
		BoxList = boxList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

}
