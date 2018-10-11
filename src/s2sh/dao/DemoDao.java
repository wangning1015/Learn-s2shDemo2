package s2sh.dao;

import java.util.List;

import s2sh.entity.Demo;

public interface DemoDao {
	public List<Demo> getInfo();

	public String deleteInfo(Integer id);
}
