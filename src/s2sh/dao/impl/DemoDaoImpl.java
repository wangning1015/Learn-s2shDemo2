package s2sh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import s2sh.dao.DemoDao;
import s2sh.entity.Demo;

@Repository // 用于标注数据访问组件，即DAO组件，使用@Repository类注解自动注入，并且作用域范围为非单例
@SuppressWarnings({ "unchecked", "rawtypes" })
public class DemoDaoImpl implements DemoDao {

	@Autowired // 使用spring内置注解@Autowired自动注入实例
	private SessionFactory sessionFactory;

	@Override
	public List<Demo> getInfo() {

		// 重新建立一个新的session
		Session session = sessionFactory.openSession();

		// 创建Query
		Query query = session.createQuery("from Demo");

		// 将所有的数据查询出来并放到List集合里
		List<Demo> demoInfo = query.getResultList();

		// 关闭session
		session.close();
		// 返回list集合
		return demoInfo;

	}

	@Override
	public String deleteInfo(Integer id) {
		// 重新建立一个新的session
		Session session = sessionFactory.openSession();
		// 创建Query并将id值设置为传过来的参数值
		Query query = session.createQuery("from Demo where id=:mid");
		query.setParameter("mid", id);
		// 将结果集保存到List<News>集合里
		List<Demo> deleteList = query.getResultList();

		// 判断deleteList有没有值，如果有，则执行下面的语句，如果没有，则什么都不做
		if (deleteList.size() == 1) {
			// 获取deleteList中的值并保存到News对象中
			Demo demo = deleteList.get(0);
			// 在控制台输出：删除对象和id值
			System.out.println("删除对象：" + demo.getName());
			// 创建事务
			session.getTransaction().begin();
			// 删除对象
			session.delete(demo);
			// 提交事务
			session.getTransaction().commit();
			// 关闭session
			session.close();
		}

		// 返回字符串deleteOK
		return "deleteOK";
	}

}
