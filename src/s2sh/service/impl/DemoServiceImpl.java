package s2sh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import s2sh.dao.DemoDao;
import s2sh.entity.Demo;
import s2sh.service.DemoService;

@Service // 使用@Service类注解自动注入，并且作用域范围为非单例
public class DemoServiceImpl implements DemoService {

	@Autowired // 使用spring内置注解@Autowired自动注入实例
	private DemoDao demoDao;

	@Override
	public List<Demo> getInfo() {

		// 调用DemoDao的getInfo方法存入到List<Demo>集合里
		List<Demo> demoInfo = demoDao.getInfo();
		// 返回List集合
		return demoInfo;
	}

	@Override
	public String deleteInfo(Integer id) {

		// 定义一个字符串保存到returnValue变量里
		String returnValue = "deleteFailed";

		// 调用NewsDao的deleteSingleNews方法
		returnValue = demoDao.deleteInfo(id);

		// 返回returnValue
		return returnValue;
	}
}
