package com.kirk.WebServices;

/**
 * Created by kirk on 6/25/2017.
 */

/**
 *  This class serves to maintain key required information that will be needed for n types of web services inorder to
 *  invoke the service on the network/internet
 */
public class WebServiceInfo
{
    private String protocal="http://";
    private String hostAddress;
    private String portNumber="";
    private String colon=":";
    private String serviceName;
    private  String WSLD_NAMESPACE;

    private String SOAP_ACTION;
    private String  OPERATION_NAME;

    private String SOAP_ADDRESS;


    public WebServiceInfo()
    {

    }


    /**
     * This constructor creates  and sets data in this object based by the array containing the service info
     * from client code, it is reccommened to place this array and data in a class retrieve it with an accessor
     * this method will set only core information that will
     * @param servicegenDescription array of strings where each index should contain specific information
     *
     */
    public WebServiceInfo(String[] servicegenDescription )
    {   this.protocal= servicegenDescription[0];
        this.hostAddress= servicegenDescription[1];
        this.portNumber= servicegenDescription[2];
        
        this.serviceName="";
        this.WSLD_NAMESPACE="";
        this.SOAP_ACTION="";
        this.OPERATION_NAME="";
        this.SOAP_ADDRESS="";

    }


    public String getProtocal() {
        return protocal;
    }

    public void setProtocal(String protocal) {
        this.protocal = protocal;
    }


    public String getSOAP_ACTION() {
        return SOAP_ACTION;
    }

    public void setSOAP_ACTION(String SOAP_ACTION) {
        this.SOAP_ACTION = SOAP_ACTION;
    }

    public String getOPERATION_NAME() {
        return OPERATION_NAME;
    }

    public void setOPERATION_NAME(String OPERATION_NAME) {
        this.OPERATION_NAME = OPERATION_NAME;
    }

    public String getWSLD_NAMESPACE() {
        return WSLD_NAMESPACE;
    }

    public void setWSLD_NAMESPACE(String WSLD_NAMESPACE) {
        this.WSLD_NAMESPACE = WSLD_NAMESPACE;
    }

    public String getSOAP_ADDRESS() {
        return SOAP_ADDRESS;
    }

    public void setSOAP_ADDRESS() {
        this.SOAP_ADDRESS = new StringBuilder()
                .append(getProtocal())
                .append(getHostAddress())
                .append(colon)
                .append(getPortNumber())
                .append(getServiceName())
                .toString();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public void setHostAddress(String hostAdress) {
        this.hostAddress = hostAdress;
    }
    public String getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(String portNumber) {
        this.portNumber = portNumber;
    }

    public String getColon() {
        return colon;
    }

    public void setColon(String colon) {
        this.colon = colon;
    }
}
