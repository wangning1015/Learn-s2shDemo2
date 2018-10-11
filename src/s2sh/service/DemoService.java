package s2sh.service;

import java.util.List;

import s2sh.entity.Demo;

public interface DemoService {
	public List<Demo> getInfo();

	public String deleteInfo(Integer id);
}
