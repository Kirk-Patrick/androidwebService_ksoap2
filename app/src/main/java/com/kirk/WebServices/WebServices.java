package com.kirk.WebServices;

/**
 * Created by Adrian on 9/17/2017.
 */

public class WebServices {



    public WebServiceInfo getAddServiceInfo()
    {
        String[] servicegenDescription = {"http://", "192.168.43.154", "51051"};

        WebServiceInfo webinfo = new WebServiceInfo(servicegenDescription);
        webinfo.setServiceName("/WebService.asmx");

        webinfo.setSOAP_ACTION("http://tempuri.org/add");
        webinfo.setOPERATION_NAME("add");
        webinfo.setWSLD_NAMESPACE("http://tempuri.org/");
        webinfo.setSOAP_ADDRESS();

        return webinfo;

    }


    public WebServiceInfo getW3SchoolsConvert()
    {
        String[] servicegenDescription = {"https://", "www.w3schools.com/xml", ""};

        WebServiceInfo webinfo = new WebServiceInfo(servicegenDescription);
        webinfo.setColon("");
        webinfo.setServiceName("/tempconvert.asmx");

        webinfo.setSOAP_ACTION("https://www.w3schools.com/xml/FahrenheitToCelsius");
        webinfo.setOPERATION_NAME("FahrenheitToCelsius");
        webinfo.setWSLD_NAMESPACE("https://www.w3schools.com/xml/");
        webinfo.setSOAP_ADDRESS();

        return webinfo;

    }



}
