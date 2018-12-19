package cn.hnck.com.action.card;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.hnck.com.dto.CardDTO;
import cn.hnck.com.entity.Card;
import cn.hnck.com.service.RetrieveService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * ClassName: CardRetrieveAction
 * 
 * @Description: ����վaction
 * @author XHChen
 * @date 2018��12��1�� ����11:48:35
 */
public class CardRetrieveAction extends ActionSupport implements
		ModelDriven<CardDTO> {

	private static final long serialVersionUID = 1L;
	// ����ʵ����
	private CardDTO cardDTO = new CardDTO();

	@Override
	public CardDTO getModel() {
		return cardDTO;
	}

	// ע��service ioc
	private RetrieveService retrieveService;

	public void setRetrieveService(RetrieveService retrieveService) {
		this.retrieveService = retrieveService;
	}

	private int[] BoxList; // ��ѡid

	// ��ҳ
	private int page;
	private int maxPage;

	// ����ҳ��
	private HttpServletRequest request;

	// ģ������
	public String search() throws Exception {

		// ����retrieveService������ѯ����
		List<Card> cards = this.retrieveService.searchCard(cardDTO.getName(),
				"1");

		// ��������Ӧ��ҳ��
		ActionContext.getContext().put("cards", cards);

		return "rfind";
	}

	// ��card�Ƶ�����վ
	public String revert() throws Exception {

		// ����retrieveService������������
		this.retrieveService.revertCard(BoxList, "1");

		return "rsuccess";
	}

	// ��ѯ����վ
	public String find() throws Exception {

		// �������
		this.request = ServletActionContext.getRequest();

		// ������ݿ����ҳ��
		int maxPage = this.retrieveService.maxSize("1");

		// ���õ�ǰҳ��
		int pageNo = 1;

		// ����ÿҳ��Ϣ��
		int pageSize = 10;

		// ���µ�ǰҳ��
		if (page > 0) {
			pageNo = page;
		}

		// ����retrieveService������ѯ����
		List<Card> cards = this.retrieveService.findRevertCard("1", pageNo,
				pageSize);

		// �ѽ����Ӧ��ҳ��
		ActionContext.getContext().put("cards", cards);

		request.setAttribute("page", pageNo);

		request.setAttribute("maxPage", maxPage);

		return "rfind";
	}

	// ɾ����Ƭ��Ϣ
	public String delete() throws Exception {

		// ����retrieveService����ɾ������
		this.retrieveService.deleteRevertCard(cardDTO.getId());

		return "rsave";
	}

	// ɾ����ѡ
	public String delList() throws Exception {

		// ����retrieveService����ɾ������
		this.retrieveService.delListCard(BoxList);

		return "rsave";

	}

	// ��Ƭ��ԭ
	public String reduction() throws Exception {

		// ����retrieveService�����ָ�����
		this.retrieveService.reductionCard(BoxList, "0");

		return "rsave";
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
