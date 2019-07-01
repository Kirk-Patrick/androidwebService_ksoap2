package com.kirk.WebServices;

import com.kirk.WebServices.*;

import java.util.ArrayList;

public class ServicePropertyList {
	private ArrayList<ServiceProperty> servicePropertyList; // method to maintain list of properties
	
	public ServicePropertyList()
	{
		//instatiate the arrayList to maintain the list of properties in memory at creation of this class
		servicePropertyList = new ArrayList<ServiceProperty>();
	}
	/**
	 * Adds a property to the private list of ServiceProperty objects
	 * @param serviceproperty  is added to the private list of this class
	 */
	public void addServiceProperty(ServiceProperty serviceproperty )
	{
		servicePropertyList.add(serviceproperty);
		
	}

	public void setServiceProperties(String name,Object value)
	{
		ServiceProperty property = new ServiceProperty(name, value);
		this.addServiceProperty(property);
	}
	public int totalProperties()
	{
		return servicePropertyList.size();
	}
	/**
	 * returns arrayList of serviceproperties
	 * @return  ArrayList<ServiceProperty>
	 */
	public ArrayList<ServiceProperty> getServicePropertyList() {
		return servicePropertyList;
	}

	
	
	

}
