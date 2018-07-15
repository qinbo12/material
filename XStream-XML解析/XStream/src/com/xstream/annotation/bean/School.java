package com.xstream.annotation.bean;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * <p>学校类</P>
 * @author qinbo
 *
 */

@XStreamAlias("School")
public class School {
	@XStreamImplicit
	/** 学生信息集合 */
	private List<Student> lsStudent = null;

	
	public School() {}


	public School(List<Student> lsStudent) {
		this.lsStudent = lsStudent;
	}


	public List<Student> getLsStudent() {
		return lsStudent;
	}


	public void setLsStudent(List<Student> lsStudent) {
		this.lsStudent = lsStudent;
	}


	@Override
	public String toString() {
		return "School [lsStudent=" + lsStudent + "]";
	}

}
