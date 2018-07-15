package com.xstream;

/** 
 * <p>地址类</p>
 * @author 秦博
 *
 */
public class Address {
	
	/** 国家 */
	private String country = null;
	
	/** 省 */
	private String province = null;
	
	/** 市 */
	private String city = null;
	
	/** 县 */
	private String county = null;

	
	public Address() {}

	public Address(String country, String province, String city, String county) {
		this.country = country;
		this.province = province;
		this.city = city;
		this.county = county;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", province=" + province
				+ ", city=" + city + ", county=" + county + "]";
	}
	
}
