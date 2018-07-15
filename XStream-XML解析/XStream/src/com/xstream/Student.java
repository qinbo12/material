package com.xstream;

/**
 * <p>学生类</p>
 * @author qinbo
 *
 */
public class Student {
	
	/** 姓名 */
	private String name = null;
	
	/** 年龄 */
	private String age = null;
	
	/** 性别 */
	private String sex = null;
	
	/** 地址 */
	private Address address = null;

	
	public Student() {}


	public Student(String name, String age, String sex, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex
				+ ", address=" + address + "]";
	}

}
