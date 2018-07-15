package com.xstream.annotation.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Student")
public class Student {
	@XStreamAlias("name")
	/** 姓名 */
	private String name = null;
	
	@XStreamAlias("age")
	/** 年龄 */
	private String age = null;

	
	public Student() {}


	public Student(String name, String age) {
		this.name = name;
		this.age = age;
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


	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	
}
