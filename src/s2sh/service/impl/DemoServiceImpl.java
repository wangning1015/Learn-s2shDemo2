package s2sh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import s2sh.dao.DemoDao;
import s2sh.entity.Demo;
import s2sh.service.DemoService;

@Service // ʹ��@Service��ע���Զ�ע�룬����������ΧΪ�ǵ���
public class DemoServiceImpl implements DemoService {

	@Autowired // ʹ��spring����ע��@Autowired�Զ�ע��ʵ��
	private DemoDao demoDao;

	@Override
	public List<Demo> getInfo() {

		// ����DemoDao��getInfo�������뵽List<Demo>������
		List<Demo> demoInfo = demoDao.getInfo();
		// ����List����
		return demoInfo;
	}

	@Override
	public String deleteInfo(Integer id) {

		// ����һ���ַ������浽returnValue������
		String returnValue = "deleteFailed";

		// ����NewsDao��deleteSingleNews����
		returnValue = demoDao.deleteInfo(id);

		// ����returnValue
		return returnValue;
	}
}
