package s2sh.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import s2sh.entity.Demo;
import s2sh.service.DemoService;

@Controller // ʹ��@Controller��ע���Զ�ע�룬����������ΧΪ�ǵ���
@Scope("prototype") // scope������������ spring bean��������prototype��ʾÿ�λ��bean��������һ���µĶ���
public class DemoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// ��ȡ�ӿͻ��˴��ݹ�����ֵ
	private Integer id;

	// strtus�Զ��ĸ�ֵ
	public void setId(Integer id) {
		this.id = id;
	}

	@Autowired // ʹ��spring����ע��@Autowired�Զ�ע��ʵ��
	private DemoService demoService;

	private List<Demo> demoInfoList;

	// ��ѯ����������
	public String getInfo() {

		demoInfoList = demoService.getInfo();

		return "success";
	}

	// ɾ��ĳ������
	public String deleteSingleInfo() {

		System.out.println("�ͻ��˴�������idֵ�ǣ�" + id);

		String returnValue = demoService.deleteInfo(id);

		return returnValue;
	}

	public List<Demo> getDemoInfoList() {
		return demoInfoList;
	}

	public void setDemoInfoList(List<Demo> demoInfoList) {
		this.demoInfoList = demoInfoList;
	}
}
