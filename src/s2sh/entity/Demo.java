package s2sh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 跟数据库表一致，作为一个java对象
 * 1个对象代表的是数据库表中的一行记录
 * 1个属性代表的是表中的一个字段
 * 
 * 使用注解后不需要映射文件
 */

@Entity // 声明当前类为hibernate映射到数据库中的实体类
@Table(name = "demoTest") // 声明table的名称
public class Demo {

	@Id // 声明此列为主键,作为映射对象的标识符
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name", nullable = false)
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
