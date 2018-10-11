package s2sh.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import s2sh.entity.Demo;
import s2sh.service.DemoService;

@Controller // 使用@Controller类注解自动注入，并且作用域范围为非单例
@Scope("prototype") // scope就是用来配置 spring bean的作用域，prototype表示每次获得bean都会生成一个新的对象
public class DemoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	// 获取从客户端传递过来的值
	private Integer id;

	// strtus自动的赋值
	public void setId(Integer id) {
		this.id = id;
	}

	@Autowired // 使用spring内置注解@Autowired自动注入实例
	private DemoService demoService;

	private List<Demo> demoInfoList;

	// 查询出所有数据
	public String getInfo() {

		demoInfoList = demoService.getInfo();

		return "success";
	}

	// 删除某条数据
	public String deleteSingleInfo() {

		System.out.println("客户端传过来的id值是：" + id);

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
