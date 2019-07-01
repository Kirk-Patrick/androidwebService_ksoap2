package com.kirk.WebServices;

public class ServiceProperty {

	private String name;
	private Object value;
	
	/**
	 * uses only on constructor create a service property will require a name and a value do so in constructor
	 * when creating an object that will represent a property that will be added to Ksoap.AddProperty method
	 * @param name
	 * @param value
	 */
	public ServiceProperty(String name,Object value)
	 {
		this.name = name;
		this.value = value;
     }

	/**
	 * gets the name of a property
	 * @return name of property
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets the value of a property
	 * @return value of property
	 */
	public Object getValue() {
		return value;
	}
	
}
