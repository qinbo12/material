package com.bean;

/**
 * 使用Book实体类保存xml内容和结构
 * @author qinbo
 *
 */
public class Book {
	/**
	 * id属性
	 */
	private String id = null;
	/**
	 * name标签
	 */
	private String name = null;
	/**
	 * author标签
	 */
	private String author = null;
	/**
	 * year标签
	 */
	private String year = null;
	/**
	 * price标签
	 */
	private String price = null;
	
	public Book() {}

	public Book(String id, String name, String author, String year) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.year = year;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", year=" + year + ", price=" + price + "]";
	}
}
