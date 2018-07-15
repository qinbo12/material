package com.SAXHandler;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.bean.Book;

/**
 * 重写SAX解析Handler
 * @author qinbo
 *
 */
public class SAXPaserHandler extends DefaultHandler {
	/**
	 * 节点内容
	 */
	private String value = null;
	/**
	 * 声明Book对象
	 */
	private Book book = null;
	/**
	 * 使用List存储Book对象
	 */
	private List<Book> lsBook = new ArrayList<Book>();

	
	public List<Book> getLsBook() {
		return lsBook;
	}

	public void setLsBook(List<Book> lsBook) {
		this.lsBook = lsBook;
	}

	/**
	 * 用来标识开始标签
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		//开始解析book元素的属性
		if("book".equals(qName)) {
			//实例化Book对象
			book = new Book();
			
			System.out.println("=====================开始解析某一本书====================");
			//1.已知book元素下的属性名称，获取属性
//			String value = attributes.getValue("id");
//			System.out.println("book的属性值：" + value);
			
			//2.不知道book元素下的属性名称及属性个数
			int length = attributes.getLength();
			for (int i = 0; i < length; i++) {
				//获取id属性
				if("id".equals(attributes.getQName(i))) {
					book.setId(attributes.getValue(i));
				}
				
				//获取属性名
				System.out.print("book的第" + (i + 1) + "个属性名："
						+ attributes.getQName(i));
				//属性值
				System.out.println(" --属性值：" + attributes.getValue(i));
			}
		} else if(!"bookstore".equals(qName))  {
			System.out.print("节点名：" + qName);
		}
	}
	
	/**
	 * 用来标识结束标签
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		//结束简析book元素
		if("book".equals(qName)) {
			lsBook.add(book);
			book = null;
			System.out.println("=====================结束解析某一本书====================");
		} else if("name".equals(qName)) {
			book.setName(value);
		} else if("author".equals(qName)) {
			book.setAuthor(value);
		} else if("year".equals(qName)) {
			book.setYear(value);
		} else if("price".equals(qName)) {
			book.setPrice(value);
		}
	}
	
	/**
	 * 获取节点值
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		//节点值
		value = new String(ch, start, length);
		if(!value.trim().equals("")) {
			System.out.println(" --节点值：" + value);
		}
	}
	
	/**
	 * 开始SAX解析
	 */
	@Override
	public void startDocument() throws SAXException {
		System.out.println("开始SAX解析");
	}
	
	/**
	 * 结束SAX解析
	 */
	@Override
	public void endDocument() throws SAXException {
		System.out.println("结束SAX解析");
	}
}
