package s2sh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import s2sh.dao.DemoDao;
import s2sh.entity.Demo;

@Repository // ���ڱ�ע���ݷ����������DAO�����ʹ��@Repository��ע���Զ�ע�룬����������ΧΪ�ǵ���
@SuppressWarnings({ "unchecked", "rawtypes" })
public class DemoDaoImpl implements DemoDao {

	@Autowired // ʹ��spring����ע��@Autowired�Զ�ע��ʵ��
	private SessionFactory sessionFactory;

	@Override
	public List<Demo> getInfo() {

		// ���½���һ���µ�session
		Session session = sessionFactory.openSession();

		// ����Query
		Query query = session.createQuery("from Demo");

		// �����е����ݲ�ѯ�������ŵ�List������
		List<Demo> demoInfo = query.getResultList();

		// �ر�session
		session.close();
		// ����list����
		return demoInfo;

	}

	@Override
	public String deleteInfo(Integer id) {
		// ���½���һ���µ�session
		Session session = sessionFactory.openSession();
		// ����Query����idֵ����Ϊ�������Ĳ���ֵ
		Query query = session.createQuery("from Demo where id=:mid");
		query.setParameter("mid", id);
		// ����������浽List<News>������
		List<Demo> deleteList = query.getResultList();

		// �ж�deleteList��û��ֵ������У���ִ���������䣬���û�У���ʲô������
		if (deleteList.size() == 1) {
			// ��ȡdeleteList�е�ֵ�����浽News������
			Demo demo = deleteList.get(0);
			// �ڿ���̨�����ɾ�������idֵ
			System.out.println("ɾ������" + demo.getName());
			// ��������
			session.getTransaction().begin();
			// ɾ������
			session.delete(demo);
			// �ύ����
			session.getTransaction().commit();
			// �ر�session
			session.close();
		}

		// �����ַ���deleteOK
		return "deleteOK";
	}

}
