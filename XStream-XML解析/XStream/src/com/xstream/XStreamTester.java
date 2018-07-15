package com.xstream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.InputSource;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

/**
 * <p>将对象转换为XML</p>
 * @author qinbo
 *
 */
public class XStreamTester {
	public static void main(String[] args) {
		
		Student student = getStudent();
		
		XStream xstream = new XStream(new StaxDriver());
		String xml = xstream.toXML(student);
		
//		File file = new File("C:\\Users\\lenovo\\Desktop\\students.xml");
		System.out.println(formatXml(xml));
		
		Student stu = (Student) xstream.fromXML(xml);
		System.out.println(stu.toString());
	}
	
	/**
	 * <p>设置Student的信息</p>
	 * @return
	 */
	private static Student getStudent() {
		
		Address address = new Address();
		address.setCountry("中华人民共和国");
		address.setProvince("陕西省");
		address.setCity("榆林市");
		address.setCounty("府谷县");
		
		Student student = new Student();
		student.setName("秦博");
		student.setAge("23");
		student.setSex("男");
		student.setAddress(address);
		
		return student;
	}
	
	public static String formatXml(String xml){
	      try{
	         Transformer serializer= SAXTransformerFactory.newInstance().newTransformer();
	         serializer.setOutputProperty(OutputKeys.INDENT, "yes");
	         serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	         Source xmlSource=new SAXSource(new InputSource(new ByteArrayInputStream(xml.getBytes())));
	         StreamResult res =  new StreamResult(new ByteArrayOutputStream()); 
	         //StreamResult res =  new StreamResult(new File("C:\\Users\\lenovo\\Desktop\\students.xml"));            
	         serializer.transform(xmlSource, res);
	         return new String(((ByteArrayOutputStream)res.getOutputStream()).toByteArray());
	      }catch(Exception e){         
	         return xml;
	      }
	   }

}
