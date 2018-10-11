package s2sh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * �����ݿ��һ�£���Ϊһ��java����
 * 1���������������ݿ���е�һ�м�¼
 * 1�����Դ�����Ǳ��е�һ���ֶ�
 * 
 * ʹ��ע�����Ҫӳ���ļ�
 */

@Entity // ������ǰ��Ϊhibernateӳ�䵽���ݿ��е�ʵ����
@Table(name = "demoTest") // ����table������
public class Demo {

	@Id // ��������Ϊ����,��Ϊӳ�����ı�ʶ��
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
