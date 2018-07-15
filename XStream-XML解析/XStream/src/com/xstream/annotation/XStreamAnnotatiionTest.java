package com.xstream.annotation;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.xstream.annotation.bean.School;
import com.xstream.annotation.bean.Student;

public class XStreamAnnotatiionTest {
	public static void main(String[] args) {
		// 创建XML转换对象
		XStream stream = new XStream(new DomDriver());
		// 设置XML支持注解方式
		stream.autodetectAnnotations(true);
		// XStream解析时忽略多余字段
		stream.ignoreUnknownElements();
		
		// 封装List
		List<Student> lsStudent = new ArrayList<Student>();
		Student stu1 = new Student("秦博1", "23");
		Student stu2 = new Student("秦博2", "24");
		Student stu3 = new Student("秦博3", "25");
		Student stu4 = new Student("秦博4", "26");
		lsStudent.add(stu1);
		lsStudent.add(stu2);
		lsStudent.add(stu3);
		lsStudent.add(stu4);
		
		School school = new School();
		school.setLsStudent(lsStudent);
		
		// 转换为 XML
		String xml = stream.toXML(school);
		System.out.println(xml);
		
		//School sch = (School) stream.fromXML(xml);
		//System.out.println(sch.getLsStudent().size());
		
		School sch = (School) stream.fromXML("<School><Student><name>秦博1</name><age>23</age></Student>"
				+ "<Student><sex>1</sex><name>秦博2</name><age>24</age></Student>"
				+ "<Student><name>秦博3</name><age>25</age></Student>"
				+ "<Student><name>秦博4</name><age>26</age></Student></School>");
		System.out.println(sch.getLsStudent().size());
	}
}
