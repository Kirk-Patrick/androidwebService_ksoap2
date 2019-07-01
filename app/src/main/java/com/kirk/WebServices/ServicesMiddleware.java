package com.kirk.WebServices;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 *  ServicesMiddleware class serves to be a middleware library class
 *  that contains generic methods to establish communication via a network
 *  to some remote .net services  such that the Webservice can be consumed in
 *  this application
 */
public class ServicesMiddleware
{
    private WebServiceInfo webServiceInfo;



    /**
     * getSoapSerializationEnvelope is a private helper method that takes a SoapObject request
     * as a parameter and returns a SoapSerialized envelop
     * @param request is the soapObject request passed to this method
     * @return  a SoapSerializationEnvelope
     */
    private final SoapSerializationEnvelope getSoapSerializationEnvelope(SoapObject request) {
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.bodyOut = request;
        envelope.dotNet = true; // mark this envelop to be a .net service
        envelope.setOutputSoapObject(request);
        return envelope;
    }

    /**
     *  takes a object of type WebServiceInfo and use it in the class
     * @param webInfoObj an object containing critical web service description data
     */
   public String setWebServiceInfo(WebServiceInfo webInfoObj)
   {   
	   if(webInfoObj!=null)
		   this.webServiceInfo=webInfoObj;
       return "method parameter object had no data  web service info not set";
   }
   
   /**
    * use this method to calls web services that dont require parameters
    * @return
    */
    public String  callWebService()
    {
       SoapObject request = getSoapRequest();
       return makeCall(request);
    }
    /**
     *  calls a web service which needs to add property information => for service methods that have parameters
     * @param listOfProperties
     * @return
     */
    public String  callWebService(ServicePropertyList listOfProperties)
    {  SoapObject request = getSoapRequest();
       //traverse the array list for each service property found in list bigO(n)
         for(ServiceProperty p:listOfProperties.getServicePropertyList())
         {// traverse and add properties for the list of property to the SoapObject request
    	   request.addProperty(p.getName(),p.getValue());
         }
        return makeCall(request);
    }

    /**
     * returns a soapObject representing a soap request
     * @return SoapObject
     */
    private SoapObject getSoapRequest()
    {
        return  new SoapObject(this.webServiceInfo.getWSLD_NAMESPACE() ,this.webServiceInfo.getOPERATION_NAME());
    }

    private String makeCall(SoapObject request)
    {    SoapSerializationEnvelope envelope = getSoapSerializationEnvelope(request);
         return callingWebService(this.webServiceInfo.getSOAP_ADDRESS(),this.webServiceInfo.getSOAP_ACTION(),envelope);
    }

    /**
     * callWebServiceHelper private method does the call to consume a web service and returns a responds 
     * @param SOAP_ADDRESS the Address of the service
     * @param SOAP_ACTION the service action
     * @param envelope  a Soap serlized envelop
     * @return returns the responds output from the service
     */
    private String  callingWebService(String SOAP_ADDRESS,  String SOAP_ACTION, SoapSerializationEnvelope envelope )
    {
        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        httpTransport.debug = true;
        Object response = null;
        try
        {
            httpTransport.call(SOAP_ACTION, envelope);
            response = envelope.getResponse();
        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        return response.toString(); // regardless of the result of this computation finally return a responds
    }

   

}
