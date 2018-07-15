package com.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * XML转对象工具类
 * @author qinbo
 *
 */
public class XMLUtils {
	
	/**
	 * XML转为对象
	 * @param clazz
	 * @param xml
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T parseForXml(Class<T> clazz, String xml) {
		// 创建解析XML对象
		XStream stream = new XStream(new DomDriver());
		// 处理注解
		stream.processAnnotations(clazz);
		// 将XML转换为bean对象
		T t = (T) stream.fromXML(xml);
		
		return t;
	}
	
	/**
	 * 对象转为XML
	 * @param obj
	 * @return
	 */
	public static String beanToXML(Object obj) {
		// 创建解析XML对象
		XStream stream = new XStream(new DomDriver());
		// 处理注解
		stream.processAnnotations(obj.getClass());
		// 将对象转为XML
		String xml = stream.toXML(obj);
		
		return xml;
	}
}
