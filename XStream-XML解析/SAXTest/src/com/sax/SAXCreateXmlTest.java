package com.sax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.bean.Book;

/**
 * SAX创建XML
 * @author qinbo
 *
 */
public class SAXCreateXmlTest {
	/**
	 * 创建SAX XML
	 */
	public static void createSAXXMl() {
		//获取xml内容
		List<Book> lsBook = SAXTest.paseXML();
		
		//生成xml
		//1.创建SAXTransformerFactory对象
		SAXTransformerFactory saxTransformerFactory = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
		try {
			//2.创建TransformerHandler对象
			TransformerHandler transformerHandler = saxTransformerFactory.newTransformerHandler();
			//3.创建Transformer对象
			Transformer transformer = transformerHandler.getTransformer();
			//4.通过Transformer对象设置生成的xml的属性
			//设置编码
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			//设置换行
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			
			File file = new File("xml/books1.xml");
			if(!file.exists()) {
				file.createNewFile();
			}
			
			//5.创建Result对象，并使其与Handler关联
			Result result = new StreamResult(new FileOutputStream(file));
			transformerHandler.setResult(result);
			//6.利用Handler对象进行xml文件的编写
			//打开document
			transformerHandler.startDocument();
			//创建AttributesImpl对象
			AttributesImpl attr = new AttributesImpl();
			//创建bookstore节点
			transformerHandler.startElement("", "", "bookstore", attr);
			
			//遍历lsBook生成xml内容
			for (Book book : lsBook) {
				//创建book节点
				attr.clear();
				attr.addAttribute("", "", "id", "", book.getId());
				transformerHandler.startElement("", "", "book", attr);
				
				attr.clear();
				//name节点
				if(null != book.getName() && !"".equals(book.getName().trim())) {
					transformerHandler.startElement("", "", "name", attr);
					transformerHandler.characters(book.getName().toCharArray(), 0, book.getName().length());
					transformerHandler.endElement("", "", "name");
				}
				//author节点
				if(null != book.getAuthor() && !"".equals(book.getAuthor().trim())) {
					transformerHandler.startElement("", "", "author", attr);
					transformerHandler.characters(book.getAuthor().toCharArray(), 0, book.getAuthor().length());
					transformerHandler.endElement("", "", "author");
				}
				//year节点
				if(null != book.getYear() && !"".equals(book.getYear().trim())) {
					transformerHandler.startElement("", "", "year", attr);
					transformerHandler.characters(book.getYear().toCharArray(), 0, book.getYear().length());
					transformerHandler.endElement("", "", "year");
				}
				//price节点
				if(null != book.getPrice() && !"".equals(book.getPrice().trim())) {
					transformerHandler.startElement("", "", "price", attr);
					transformerHandler.characters(book.getPrice().toCharArray(), 0, book.getPrice().length());
					transformerHandler.endElement("", "", "price");
				}
				
				//关闭book节点
				transformerHandler.endElement("", "", "book");
			}
			
			//关闭bookstore节点
			transformerHandler.endElement("", "", "bookstore");
			//关闭document
			transformerHandler.endDocument();
			
			System.out.println("生成xml成功！");
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SAXCreateXmlTest.createSAXXMl();
	}
}
