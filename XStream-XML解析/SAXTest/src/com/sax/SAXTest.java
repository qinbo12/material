package com.sax;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.SAXHandler.SAXPaserHandler;
import com.bean.Book;

/**
 * SAX解析
 * @author qinbo
 *
 */
public class SAXTest {
	private static List<Book> lsBook = null;
	
	public static List<Book> paseXML() {
		//使用SAXParserFactory.newInstance()构建SAXParserFactory对象
		SAXParserFactory sf = SAXParserFactory.newInstance();
		//通过SAXParserFactory创建SAXParser对象
		try {
			SAXParser saxParser = sf.newSAXParser();
			//创建SAXPaserHandler对象
			SAXPaserHandler handler = new SAXPaserHandler();
			saxParser.parse("xml/books.xml", handler);
			lsBook = handler.getLsBook();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lsBook;
	}
	
	public static void main(String[] args) {
		//使用SAXParserFactory.newInstance()构建SAXParserFactory对象
		SAXParserFactory sf = SAXParserFactory.newInstance();
		//通过SAXParserFactory创建SAXParser对象
		try {
			SAXParser saxParser = sf.newSAXParser();
			//创建SAXPaserHandler对象
			SAXPaserHandler handler = new SAXPaserHandler();
			saxParser.parse("xml/books.xml", handler);
			lsBook = handler.getLsBook();
			for (Book book : lsBook) {
				System.out.println(book.toString());
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
